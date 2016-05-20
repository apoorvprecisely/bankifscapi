import javax.inject.*;
import play.*;
import play.filters.gzip.GzipFilter;
import play.mvc.EssentialFilter;
import play.http.HttpFilters;
import play.mvc.*;

import filters.ExampleFilter;

/**
 * This class configures filters that run on every request. This
 * class is queried by Play to get a list of filters.
 *
 * Play will automatically use filters from any class called
 * <code>Filters</code> that is placed the root package. You can load filters
 * from a different class by adding a `play.http.filters` setting to
 * the <code>application.conf</code> configuration file.
 */
@Singleton
public class Filters implements HttpFilters {

    private final Environment env;
    private final EssentialFilter exampleFilter;
    @Inject
    GzipFilter gzipFilter;
    public EssentialFilter[] filters() {
        return new EssentialFilter[] { gzipFilter.asJava() };
    }
    /**
     * @param env Basic environment settings for the current application.
     * @param exampleFilter A demonstration filter that adds a header to
     */
    @Inject
    public Filters(Environment env, ExampleFilter exampleFilter) {
        this.env = env;
        this.exampleFilter = exampleFilter;
    }
}
