
/**
 * CPSC 501
 * Inspector starter class
 *
 * @author Jonathan Hudson
 */
public class Inspector {

    public void inspect(Object obj, boolean recursive) {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive, 0);
    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
        try{
            //PRINT OUT CLASS
            System.out.print("\t".repeat(depth));
            System.out.println("CLASS");
            System.out.print("\t".repeat(depth));
            System.out.println("Class: " + c);

            //INSPECT SUPERCLASS
            if (c.getSuperclass() != null){
                System.out.print("\t".repeat(depth));
                System.out.println("SUPERCLASS -> Recursively Inspect");
                System.out.print("\t".repeat(depth));
                System.out.println("SuperClass: " + c.getSuperclass());
                System.out.print("\t".repeat(depth));
                inspectClass(c.getSuperclass(),c.getSuperclass(),recursive,depth+1);
            }else{
                System.out.print("\t".repeat(depth));
                System.out.println("SuperClass: NONE");
            }

            //INSPECT INTERFACES
           System.out.print("\t".repeat(depth));
           System.out.println("INTERFACES ( " + c +" )");
           Class[] interfaces = c.getInterfaces();

            if(interfaces.length > 0){
                for(Class inter : interfaces){
                    System.out.print("\t".repeat(depth));
                    System.out.println("INTERFACE -> Recursively Inspect " + inter);
                    inspectClass(inter,inter,recursive,depth+1);
                }
            }else{
                System.out.print("\t".repeat(depth));
                System.out.println("Interfaces -> NONE");
            }


            //INSPECT CONSTRUCTORS
            System.out.print("\t".repeat(depth));
            System.out.println("CONSTRUCTORS ( " + c +" )");
            java.lang.reflect.Constructor[] cons = c.getConstructors();

            if(cons.length > 0){
                System.out.print("\t".repeat(depth));
                System.out.println("Constructors ->");
                for(java.lang.reflect.Constructor con : cons){
                    System.out.print("\t".repeat(depth));
                    System.out.println("CONSTRUCTOR");
                    System.out.print("\t".repeat(depth));
                    System.out.println("  Name: " + con.getName());

                    Object[] exceptions = con.getExceptionTypes();
                    if(exceptions.length>0){
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Exceptions ->");
                        for(Object exception : exceptions){
                            System.out.print("\t".repeat(depth));
                            System.out.println(exception);
                        }
                    }else{
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Exceptions -> NONE");
                    }

                    Object[] params = con.getParameterTypes();
                    if(params.length>0){
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Parameter Types ->");
                        for(Object param : params){
                            System.out.print("\t".repeat(depth));
                            System.out.println(param);
                        }
                    }else{
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Parameter Types -> NONE");
                    }

                    System.out.print("\t".repeat(depth));
                    System.out.println("  Modifiers: " + java.lang.reflect.Modifier.toString(con.getModifiers()));
                }
            }else{
                System.out.print("\t".repeat(depth));
                System.out.println("Constructors -> NONE");
            }



            //INSPECT METHODS
            System.out.print("\t".repeat(depth));
            System.out.println("METHODS ( " + c +" )");
            java.lang.reflect.Method[] methods = c.getDeclaredMethods();
            if(methods.length>0){
                System.out.print("\t".repeat(depth));
                System.out.println("Methods ->");
                for(java.lang.reflect.Method method : methods){
                    System.out.print("\t".repeat(depth));
                    System.out.println("METHOD");
                    System.out.print("\t".repeat(depth));
                    System.out.println("  Name: " + method.getName());


                    Object[] exceptions = method.getExceptionTypes();
                    if(exceptions.length>0){
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Exceptions ->");
                        for(Object exception : exceptions){
                            System.out.print("\t".repeat(depth));
                            System.out.println(exception);
                        }
                    }else{
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Exceptions -> NONE");
                    }

                    Object[] params = method.getParameterTypes();
                    if(params.length>0){
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Parameter Types ->");
                        for(Object param : params){
                            System.out.print("\t".repeat(depth));
                            System.out.println(param);
                        }
                    }else{
                        System.out.print("\t".repeat(depth));
                        System.out.println("  Parameter Types -> NONE");
                    }

                    System.out.print("\t".repeat(depth));
                    System.out.println("  Return Type: " + method.getReturnType());

                    System.out.print("\t".repeat(depth));
                    System.out.println("  Modifiers: " + java.lang.reflect.Modifier.toString(method.getModifiers()));

                }
            }else{
                System.out.print("\t".repeat(depth));
                System.out.println("Methods -> NONE");
            }



            //INSPECT FIELDS
            System.out.print("\t".repeat(depth));
            System.out.println("FIELDS ( " + c +" )");
            java.lang.reflect.Field[] fields = c.getDeclaredFields();
            if(fields.length>0){
                System.out.print("\t".repeat(depth));
                System.out.println("Fields ->");
                for(java.lang.reflect.Field field : fields){
                    System.out.print("\t".repeat(depth));
                    System.out.println("FIELD");

                    System.out.print("\t".repeat(depth));
                    System.out.println("  Name: " + field.getName());

                    System.out.print("\t".repeat(depth));
                    System.out.println("  Type: " + field.getType());

                    System.out.print("\t".repeat(depth));
                    System.out.println("  Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));

                    System.out.print("\t".repeat(depth));
                    System.out.println("  Value: " + field);

                }
            }else{
                System.out.print("\t".repeat(depth));
                System.out.println("Fields -> NONE");
            }


            return;
        }catch(Exception e){
            System.out.println("Exception");
            return;
        }

    }

}