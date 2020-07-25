package com.example.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2020年07月25日 22:43
 * @ModificationHistory:
 */
public class ValidateBeanUtil {
    public ValidateBeanUtil() {
    }


    public static String validateAnnotation(Object object) {
        if(object == null) {
            return "object is required";
        } else {
            ArrayList fields = new ArrayList();
            ReflectUtil.getClassField(object, fields);
            Iterator i$ = fields.iterator();

            Field f;
            ParamValid p;
            Object v;
            label57:
            do {
                do {
                    do {
                        if(!i$.hasNext()) {
                            return "success";
                        }

                        f = (Field)i$.next();
                        p = (ParamValid)f.getAnnotation(ParamValid.class);
                    } while(p == null);

                    f.setAccessible(true);
                    v = null;

                    try {
                        v = f.get(object);
                    } catch (IllegalAccessException var7) {
                        throw new RuntimeException(var7);
                    }

                    if(v != null && !StringUtil.isBlank(v.toString())) {
                        if(v.getClass().getClassLoader() != null) {
                            String result = validateAnnotation(v);
                            if(!"success".equals(result)) {
                                return f.getName() + "." + result;
                            }
                        }

                        if(p.maxLength() >= 0 && v.toString().length() > p.maxLength()) {
                            return f.getName() + " is too long";
                        }
                        continue label57;
                    }
                } while(!p.require());

                return f.getName() + " is required";
            } while(!StringUtil.isNotBlank(p.regex()) || v.toString().matches(p.regex()));

            return f.getName() + " is error format(regex:" + p.regex() + ")";
        }
    }

    public static String validateParamByArgs(Object object, ValidateBeanUtil.CheckArgs... checkArgs) {
        if(null == object) {
            return "object is null";
        } else {
            Map map = ReflectUtil.bean2Map(object);
            ValidateBeanUtil.CheckArgs[] arr$ = checkArgs;
            int len$ = checkArgs.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                ValidateBeanUtil.CheckArgs field = arr$[i$];
                String value = (String)map.get(field.getName());
                if(StringUtil.isBlank(value)) {
                    if(!field.isNullable()) {
                        return field.getName() + " is required";
                    }
                } else if(field.getRegx() != null && !value.matches(field.getRegx())) {
                    return field.getName() + " format is error:" + value;
                }
            }

            return "success";
        }
    }

    public static String validateParam(Object object, String... fieldList) {
        if(null == object) {
            return "object is null";
        } else {
            String result = validateAnnotation(object);
            if(!"success".equals(result)) {
                return result;
            } else {
                Map map = ReflectUtil.bean2Map(object);
                String[] arr$ = fieldList;
                int len$ = fieldList.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    String field = arr$[i$];
                    if(StringUtil.isBlank((CharSequence)map.get(field))) {
                        return field + " is required";
                    }
                }

                return "success";
            }
        }
    }

    public static String validate(Object object, String... fieldList) {
        if(null == object) {
            return "the object is null";
        } else {
            Map values = ReflectUtil.getValue(object);
            String[] arr$ = fieldList;
            int len$ = fieldList.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String field = arr$[i$];
                Iterator i$1 = values.entrySet().iterator();

                while(i$1.hasNext()) {
                    Map.Entry entry = (Map.Entry)i$1.next();
                    if(((String)entry.getKey()).equalsIgnoreCase(field) && StringUtil.isBlank((CharSequence)entry.getValue())) {
                        return "the value of the param(" + (String)entry.getKey() + ") is empty";
                    }
                }
            }

            return "success";
        }
    }

    public static class CheckArgs {
        private boolean nullable;
        private String regx;
        private String name;

        public CheckArgs() {
        }

        public boolean isNullable() {
            return this.nullable;
        }

        public ValidateBeanUtil.CheckArgs setNullable(boolean nullable) {
            this.nullable = nullable;
            return this;
        }

        public String getRegx() {
            return this.regx;
        }

        public ValidateBeanUtil.CheckArgs setRegx(String regx) {
            this.regx = regx;
            return this;
        }

        public String getName() {
            return this.name;
        }

        public ValidateBeanUtil.CheckArgs setName(String name) {
            this.name = name;
            return this;
        }
    }
}
