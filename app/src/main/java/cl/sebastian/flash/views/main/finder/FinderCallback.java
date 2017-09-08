package cl.sebastian.flash.views.main.finder;

/**
 * Created by Sebastián Mena on 08-09-2017.
 */

public interface FinderCallback {

    void error(String error);
    void success();
    void notFound();

}
