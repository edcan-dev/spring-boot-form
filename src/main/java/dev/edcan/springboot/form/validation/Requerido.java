package dev.edcan.springboot.form.validation;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({FIELD, METHOD})
@Constraint(validatedBy = RequeridoValidador.class)
public @interface Requerido {
    String message() default "EL CAMPO ES REQUERIDO - USANDO ANOTACIONES";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
    

}
