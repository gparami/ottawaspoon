package ca.ottawaspoon.analysis;

import org.python.util.PythonInterpreter;
import org.python.core.*;

public class SimpleExample {

	public static void simpleJython() throws PyException
	   {
	       PythonInterpreter pi = new PythonInterpreter();
	       pi.set("integer", new PyInteger(42));
	       pi.exec("square = integer*integer");
	       PyInteger square = (PyInteger)pi.get("square");
	       System.out.println("square: " + square.asInt());
	       pi.close();
	   }
	
}
