package com.example.utils;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2020年07月25日 22:45
 * @ModificationHistory:
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectUtil {
    public ReflectUtil() {
    }

    public static final void GetClassField(Object orig, List<String> fieldlist) {
        for(Class clazz = orig.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            Field[] arr$ = fields;
            int len$ = fields.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Field field = arr$[i$];
                fieldlist.add(field.getName());
            }
        }

    }

    public static void getClassField(Object orig, List<Field> fieldList) {
        for(Class clazz = orig.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            Field[] arr$ = fields;
            int len$ = fields.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Field field = arr$[i$];
                fieldList.add(field);
            }
        }

    }

    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;

        for(Class clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                if(field != null) {
                    return field;
                }
            } catch (Exception var5) {
                ;
            }
        }

        return null;
    }

    public static Method getDeclaredMethod(Object object, String fieldName) {
        Method field = null;

        for(Class clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Method[] e = clazz.getDeclaredMethods();
                int len$ = e.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    Method method = e[i$];
                    if(method.getName().equals(fieldName)) {
                        field = method;
                    }
                }
            } catch (Exception var8) {
                ;
            }
        }

        return field;
    }

    public static boolean setFieldValue(Object obj, Object value, String fieldName) {
        if(value == null) {
            return false;
        } else {
            Field f = getDeclaredField(obj, fieldName);
            if(f == null) {
                return false;
            } else {
                f.setAccessible(true);

                try {
                    value = new Date(((Long)value).longValue());
               /*     if(f.getType() == Date.class) {
                        if(value instanceof String) {
                            value = DateUtil.parseDate((String)value);
                        } else if(value instanceof Long) {
                        }
                    }*/

                    f.set(obj, value);
                    return true;
                } catch (Exception var5) {
                    var5.printStackTrace();
                    return false;
                }
            }
        }
    }

    public static Object getFieldValue1(Object orig, String field) {
        Field f = getDeclaredField(orig, field);
        f.setAccessible(true);

        try {
            return f.get(orig);
        } catch (IllegalAccessException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static Object getFieldValue(Object orig, String field) {
        String getfunc = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
        Method getMethod = getDeclaredMethod(orig, getfunc);
        String valueObject = null;
        if(getMethod != null) {
            try {
                Object valueObject1 = getMethod.invoke(orig, (Object[])null);
                if(valueObject1 != null) {
                    valueObject = convter(valueObject1, "");
                } else {
                    valueObject = "";
                }
            } catch (Exception var6) {
                ;
            }
        }

        return valueObject;
    }

    public static void bean2Map(Map<String, String> map, String prefix, Object source) {
        if(source != null) {
            if(source instanceof Map) {
                prefix = prefix == null?"":prefix + ".";
                Iterator fields1 = ((Map)source).entrySet().iterator();

                while(fields1.hasNext()) {
                    Map.Entry m1 = (Map.Entry)fields1.next();
                    if(m1.getValue() != null) {
                        map.put(prefix + m1.getKey().toString(), m1.getValue().toString());
                    }
                }

            } else {
                ArrayList fields = new ArrayList();
                getClassField(source, fields);
                Method m = null;
                Object value = null;
                Iterator i$ = fields.iterator();

                while(i$.hasNext()) {
                    Field field = (Field)i$.next();

                    try {
                        String e = null;
                        String name = field.getName();
                        String getname = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        name = prefix == null?name:prefix + "." + name;
                        m = field.getDeclaringClass().getMethod(getname, new Class[0]);
                        if(m != null) {
                            value = m.invoke(source, new Object[0]);
                            if(isJdkClass(value.getClass())) {
                                if(value != null) {
                                    e = convter(value, "");
                                    map.put(name, e);
                                }
                            } else {
                                bean2Map(map, name, value);
                            }
                        }
                    } catch (Exception var11) {
                        ;
                    }
                }

            }
        }
    }

    public static Map<String, String> bean2Map(Object source) {
        HashMap map = new HashMap();
        bean2Map(map, (String)null, source);
        return map;
    }

    public static final Map<String, String> getValue(Object source) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        if(source != null) {
            Field[] fields = source.getClass().getDeclaredFields();
            Method m = null;
            Object value = null;
            Field[] arr$ = fields;
            int len$ = fields.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Field field = arr$[i$];

                try {
                    String e = null;
                    String name = field.getName();
                    String getname = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    m = field.getDeclaringClass().getMethod(getname, new Class[0]);
                    if(m != null) {
                        value = m.invoke(source, new Object[0]);
                        if(null == value) {
                            map.put(name, "");
                        }

                        if(isJdkClass(value.getClass())) {
                            if(value != null) {
                                e = convter(value, "");
                            } else {
                                e = "";
                            }

                            map.put(name, e);
                        } else {
                            getValue(value);
                        }
                    }
                } catch (Exception var12) {
                    ;
                }
            }
        }

        return map;
    }

    private static String convter(Object source, String date_format) {
        String curObject = null;
        Class type = source.getClass();
        if(type.getSimpleName().equals("BigDecimal")) {
            DecimalFormat df1 = new DecimalFormat("#,##0.0000");
            curObject = df1.format(source);
        } else {
            curObject = source.toString();
        }

        return curObject;
    }

    public static boolean isJdkClass(Class<?> clz) {
        return clz != null && clz.getClassLoader() == null;
    }

    public static void main(String[] args) {
        Object o = getFieldValue1(new ReflectUtil(), "name");
        System.out.println(o);
    }
}
