import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import com.sun.javafx.fxml.BeanAdapter;

import java.util.List; 
public class AnnotationContainer {
protected Map<String, Object> beanInstanceMap  = new HashMap<String, Object>();
public void bind(String packageName) {
	//initializeBean(packageName);
	//inject();
}
static Map<String, Object> initializeBeanInSamePackage() {
String pathString = AnnotationContainer.class.getClass().getResource("/").getPath();
java.io.File file  = new java.io.File(pathString);
String[] classNameStrings = file.list();
String[] classesNameWithouClassStrings = new String[classNameStrings.length];
List<Class<?>> classes = new ArrayList<Class<?>>();
for(int i = 0 ; i < classNameStrings.length ; i++) {
	classesNameWithouClassStrings[i] = classNameStrings[i].replace(".class", "");
	try {
		classes.add(Class.forName(classesNameWithouClassStrings[i]));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("error in loading class");
	}
}
Map<String, Object> objectMap = new HashMap<String, Object>();
for(Class<?> class1 : classes) {
	if(class1.getAnnotation(bean.class)!=null) {
		try {
			objectMap.put(class1.getName(),class1.newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

return objectMap;
}


}
