package br.com.goifnra.swarm.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static net.logstash.logback.marker.Markers.appendEntries

@Component
class RequestLoggingFilter implements Filter {

    private final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingFilter)

    @Override
    void init(FilterConfig filterConfig) throws ServletException {
    }

    void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res
        HttpServletRequest request = (HttpServletRequest) req
        String url = request.getServletPath()

        StopWatch stopWatch = new StopWatch()
        stopWatch.start()
        chain.doFilter(req, res)
        stopWatch.stop()

        Map<String, Object> markers = new HashMap<>()
        markers.put("res.status", response.getStatus())
        markers.put("req.executionTime", stopWatch.getTotalTimeMillis())
        LOGGER.info(appendEntries(markers), "Execution time for {} {} is {} ms", url, request.getMethod(), stopWatch.getTotalTimeMillis())
    }

    @Override
    void destroy() {

    }
}

