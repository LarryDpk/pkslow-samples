package com.pkslow.springboot.common.web.filter;

import com.pkslow.springboot.common.web.wrapper.PkslowRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
@Component
public class PkslowBaseFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        long start = System.nanoTime();
        PkslowRequestWrapper request = new PkslowRequestWrapper(req);

        ContentCachingResponseWrapper response = new ContentCachingResponseWrapper(res);

        StringBuilder sb = new StringBuilder();

        String method = request.getMethod();
        sb.append("Request Method: ").append(method).append("\n");

        sb.append("Request URI: ").append(request.getRequestURI()).append("\n");
        sb.append("Request URL: ").append(request.getRequestURL()).append("\n");
        sb.append("Request QueryString: ").append(request.getQueryString()).append("\n");
        sb.append("Request Whole URL: ")
                .append(request.getRequestURL())
                .append("?")
                .append(request.getQueryString())
                .append("\n");

        HttpHeaders headers = (new ServletServerHttpRequest(request)).getHeaders();
        sb.append("Request Headers: ").append(headers).append("\n");


        ServletInputStream servletInputStream = request.getInputStream();
        String body = StreamUtils.copyToString(servletInputStream, Charset.defaultCharset());
        sb.append("Request Body(PkslowRequestWrapper): ").append(body).append("\n");

        log.info("Received Request: \n{}", sb);

        chain.doFilter(request, response);

        StringBuilder resBuilder = new StringBuilder();

        resBuilder.append("Response Code: ").append(response.getStatus()).append("\n");
        String responseBody = new String(response.getContentAsByteArray(), response.getCharacterEncoding());
        resBuilder.append("Response Body: ").append(responseBody).append("\n");
        log.info("Response: \n{}", resBuilder);

        response.copyBodyToResponse();

        long end = System.nanoTime();
        log.info("Request Processed Time: {} ms", (end - start) * 1.0 / 1000000);
    }
}
