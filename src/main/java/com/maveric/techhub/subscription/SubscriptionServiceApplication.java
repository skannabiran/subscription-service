package com.maveric.techhub.subscription;

import com.maveric.techhub.subscription.config.AppConstants;
import com.maveric.techhub.subscription.config.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaAuditing
public class SubscriptionServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(SubscriptionServiceApplication.class);
	private final Environment env;

	public SubscriptionServiceApplication(Environment env) {
		this.env = env;
	}

	/**
	 * Initializes jhipsterJwtSampleApplication.
	 * <p>
	 * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
	 * <p>
	 * You can find more information on how profiles work with JHipster on <a href="http://www.jhipster.tech/profiles/">http://www.jhipster.tech/profiles/</a>.
	 */
	@PostConstruct
	public void initApplication() {
		Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
		if (activeProfiles.contains(AppConstants.SPRING_PROFILE_DEV) && activeProfiles.contains(AppConstants.SPRING_PROFILE_PROD)) {
			log.error("You have misconfigured your application! It should not run " +
					"with both the 'dev' and 'prod' profiles at the same time.");
		}
	}

	/**
	 * Main method, used to run the application.
	 *
	 * @param args the command line arguments
	 * @throws UnknownHostException if the local host name could not be resolved into an address
	 */
	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(SubscriptionServiceApplication.class);
		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		String[] activeProfiles = DefaultProfileUtil.getActiveProfiles(env);
		String protocol = "http";
		String port = env.getProperty("server.port");
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is up & running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}\n\t" +
						"External: \t{}://{}:{}\n\t" +
						"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol, port, protocol,
				InetAddress.getLocalHost().getHostAddress(), port, activeProfiles
				);
	}
}
