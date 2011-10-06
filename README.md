To see the problem, start the web application:

    cd spring-security-wiring
    mvn jetty:run

Browsing to the root context on [http://localhost:8080](http://localhost:8080) should work:

    Hello from insecure page

Then browse to the secured part of the site on [http://localhost:8080/secure](http://localhost:8080/secure).

Log in with anything. The result is a `NullPointerException`, which occurs because to the `service` dependency hasn't
been set:

    java.lang.NullPointerException
        at com.jayway.myapp.security.MyappAuthenticationProvider.authenticate(MyappAuthenticationProvider.java:34)
        ...

Then open the `src/main/webapp/WEB-INF/security-context.xml` and comment out the `debug` element:

    <!-- comment out this to get autowire working -->
    <debug/>

Restart the web application and try the secured part on [http://localhost:8080/secure](http://localhost:8080/secure)
again. Logging in should now work and display:

    Hello from secure page
