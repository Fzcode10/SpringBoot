package com.example.AspectDemo.Annotation;


// Marker Annotation (Without any implementation)

// Configured Annotation (With some implementation)

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 2000;

    String operation() default "";

}
