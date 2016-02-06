package dk.enterlab.graph;

import java.util.HashMap;
import java.util.Map;

public class ObjectGraph extends SimpleGraph {
	Map<String,Object> objects = null;
	
	public ObjectGraph(){
		super();
		objects = new HashMap<String, Object>();
	}
	
	public void add(String subject, Object object){
		objects.put(subject, object);
		add(subject, "_has_object", "");
	}
	
	public Object object(String subject) throws GraphException {
		if (is(subject, "_has_object", "")){
			return objects.get(subject);
		}
		else {
			throw new GraphException("No object registered with id \"" + subject + "\"!");
		}
	}
}
