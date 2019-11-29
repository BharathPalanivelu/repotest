package twitter4j;

import java.lang.reflect.InvocationTargetException;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

final class DispatcherFactory {
    private final Configuration conf;
    private final String dispatcherImpl;

    public DispatcherFactory(Configuration configuration) {
        this.dispatcherImpl = configuration.getDispatcherImpl();
        this.conf = configuration;
    }

    public DispatcherFactory() {
        this(ConfigurationContext.getInstance());
    }

    public Dispatcher getInstance() {
        try {
            return (Dispatcher) Class.forName(this.dispatcherImpl).getConstructor(new Class[]{Configuration.class}).newInstance(new Object[]{this.conf});
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        } catch (ClassNotFoundException e4) {
            throw new AssertionError(e4);
        } catch (ClassCastException e5) {
            throw new AssertionError(e5);
        } catch (NoSuchMethodException e6) {
            throw new AssertionError(e6);
        } catch (InvocationTargetException e7) {
            throw new AssertionError(e7);
        }
    }
}
