package ThreadDemo.Util.stf;

import java.lang.annotation.*;


@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Observer {
	Expect[] value();
}
