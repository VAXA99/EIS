package Lab1_CDI.Interceptor;

import lombok.NoArgsConstructor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@NoArgsConstructor
public class ProfileInterceptor {

    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception {
        long initTime = System.currentTimeMillis();
        Object result;

        try {
            Thread.sleep(100); // 100 milliseconds delay
            result = ic.proceed();
        } finally {
            long diffTime = System.currentTimeMillis() - initTime - 100;
            System.out.println(ic.getMethod() + " took " + diffTime + " millis");
        }

        return result;
    }
}
