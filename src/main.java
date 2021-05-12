import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.*;

public class main {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
//		String pathString = main.class.getClass().getResource("/").getPath();
//		System.out.println(pathString);
//		java.io.File file  = new java.io.File(pathString);
//		String[] classNameStrings = file.list();
//		for(int i = 0 ; i < classNameStrings.length ; i++) {
//			System.out.println(classNameStrings[i]);
//		}
		Method method,method2;
		Object studentObject = AnnotationContainer.initializeBeanInSamePackage().get(studentExtend.class.getName());
		System.out.println(studentObject);
		method = studentExtend.class.getDeclaredMethod("learning");
		try {
			method.invoke(studentObject, null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object teacherObject = AnnotationContainer.initializeBeanInSamePackage().get(myTeacher.class.getName());
		Field[] fiels = teacherObject.getClass().getFields();
		for(Field field :fiels) {
			
			if(field.getAnnotation(inject.class)!=null) {
				try {
					field.set(teacherObject,studentObject);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		method2 = myTeacher.class.getDeclaredMethod("teach");
		try {
			method2.invoke(teacherObject, null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
