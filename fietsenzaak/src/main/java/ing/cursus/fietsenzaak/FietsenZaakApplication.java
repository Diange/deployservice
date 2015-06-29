package ing.cursus.fietsenzaak;

import java.util.HashMap;
import java.util.Map;


import org.glassfish.jersey.server.ServerProperties;

import ing.cursus.fietsenzaak.FietsenZaakConfiguration;
import ing.cursus.fietsenzaak.resource.FietsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FietsenZaakApplication extends Application<FietsenZaakConfiguration>  {

	public static void main(String[] args) throws Exception {
		new FietsenZaakApplication().run(args);
	}
	
    @Override
    public String getName() {
        return "JSON-FietsenZaak";
    }
    
    @Override
    public void initialize(Bootstrap<FietsenZaakConfiguration> bootstrap) {
        // nothing to do yet
    }
	
	@Override
	public void run(FietsenZaakConfiguration configuration,Environment environment) throws Exception {
		
		FietsResource resource = new FietsResource();
		environment.jersey().register(resource);
		 
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(ServerProperties.WADL_FEATURE_DISABLE, false);
		environment.jersey().getResourceConfig().addProperties(properties);
	}

}
