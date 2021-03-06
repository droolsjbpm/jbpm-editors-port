package org.jboss.bpm.console.server.integration.implementation;

import org.drools.SystemEventListenerFactory;
import org.jbpm.task.*;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.TaskService;
import org.jbpm.task.service.TaskServiceSession;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExpressionCompiler;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class HumanTaskService {
	
	private static TaskService INSTANCE;
	
	public static TaskService getService() {
		if (INSTANCE == null) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.jbpm.task");
	        TaskService taskService = new TaskService(emf, SystemEventListenerFactory.getSystemEventListener());
	        TaskServiceSession taskSession = taskService.createSession();
	        // Add users
	        Map vars = new HashMap();
	        Reader reader = new InputStreamReader( HumanTaskService.class.getResourceAsStream( "LoadUsers.mvel" ) );     
	        Map<String, User> users = ( Map<String, User> ) eval( reader, vars );   
	        for ( User user : users.values() ) {
	            taskSession.addUser( user );
	        }           
	        reader = new InputStreamReader( HumanTaskService.class.getResourceAsStream( "LoadGroups.mvel" ) );      
	        Map<String, Group> groups = ( Map<String, Group> ) eval( reader, vars );     
	        for ( Group group : groups.values() ) {
	            taskSession.addGroup( group );
	        }
	        taskSession.dispose();
	        System.out.println("Task service running and started correctly !");
	        INSTANCE = taskService;
		}
		return INSTANCE;
	}

    public static Object eval(Reader reader, Map vars) {
        try {
            return eval( readerToString( reader ), vars );
        } catch ( IOException e ) {
            throw new RuntimeException( "Exception Thrown", e );
        }
    }
    
    public static String readerToString(Reader reader) throws IOException {
        int charValue = 0;
        StringBuffer sb = new StringBuffer( 1024 );
        while ( (charValue = reader.read()) != -1 ) {
            //result = result + (char) charValue;
            sb.append( (char) charValue );
        }
        return sb.toString();
    }

    public static Object eval(String str, Map vars) {
        ExpressionCompiler compiler = new ExpressionCompiler( str.trim() );

        ParserContext context = new ParserContext();
        context.addPackageImport( "org.jbpm.task" );
        context.addPackageImport( "java.util" );
        
        context.addImport( "AccessType", AccessType.class );
        context.addImport( "AllowedToDelegate", AllowedToDelegate.class );
        context.addImport( "Attachment", Attachment.class );
        context.addImport( "BooleanExpression", BooleanExpression.class );
        context.addImport( "Comment", Comment.class );
        context.addImport( "Deadline", Deadline.class );
        context.addImport( "Deadlines", Deadlines.class );
        context.addImport( "Delegation", Delegation.class );
        context.addImport( "Escalation", Escalation.class );
        context.addImport( "Group", Group.class );
        context.addImport( "I18NText", I18NText.class );
        context.addImport( "Notification", Notification.class );
        context.addImport( "OrganizationalEntity", OrganizationalEntity.class );
        context.addImport( "PeopleAssignments", PeopleAssignments.class );
        context.addImport( "Reassignment", Reassignment.class );
        context.addImport( "Status", Status.class );
        context.addImport( "Task", Task.class );
        context.addImport( "TaskData", TaskData.class );
        context.addImport( "TaskSummary", TaskSummary.class );
        context.addImport( "User", User.class );

        return MVEL.executeExpression(compiler.compile(context), vars);
    }
    
}
