grails.plugin.springsecurity.filterChain.chainMap = [
		[
				'/api/**': 'tokenValidationFilter,restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor',
				'/**': 'JOINED_FILTERS'
		],
        //Stateless chain
        [
                pattern: '/**',
				filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],

        //Traditional, stateful chain
        [
                pattern: '/stateful/**',
                filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
        ]
]


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'client.portal.api.grails.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'client.portal.api.grails.UserRole'
grails.plugin.springsecurity.authority.className = 'client.portal.api.grails.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.rest.login.useJsonCredentials = true
grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.login.endpointUrl = '/api/login'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'client.portal.api.grails.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.jwt.secret = '0ca6549172f1236d29859ebb3c7cf1893a9225a4512b224735f175369a1202b9'
grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 3600;
grails.plugin.springsecurity.logout.postOnly = true

logging.level.root = 'DEBUG'

dataSource {
	pooled = true
	dbCreate = "update"
	url = "jdbc:mysql://localhost:3306/client-portal-grails?serverTimezone=UTC"
	driverClassName = "com.mysql.cj.jdbc.Driver"
	dialect = org.hibernate.dialect.MySQL8Dialect
	username = "root"
	password = "1234"
	logSql = true
	properties {
		jmxEnabled = true
		initialSize = 5
		maxActive = 50
		minIdle = 5
		maxIdle = 25
		maxWait = 10000
		maxAge = 10 * 60000
		timeBetweenEvictionRunsMillis = 5000
		minEvictableIdleTimeMillis = 60000
		validationQuery = "SELECT 1"
		validationQueryTimeout = 3
		validationInterval = 15000
		testOnBorrow = true
		testWhileIdle = true
		testOnReturn = false
		jdbcInterceptors = "ConnectionState;StatementCache(max=200)"
		defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
	}
}


