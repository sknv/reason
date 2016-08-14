package com.github.skanukov.sparklet.apps.web.controllers.home;

import com.github.skanukov.sparklet.core.controller.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Home controller Index action.
 */
public class Index extends HomeAction implements Action {
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    private static final AtomicInteger count = new AtomicInteger(0);

    /**
     * Creates the action.
     */
    public Index() {
        logger.info("home.Index::constructor called");
    }

    /**
     * Handles the http request.
     *
     * @param req The http request.
     * @param res The http request.
     * @return Action result.
     */
    @Override
    public Object call(Request req, Response res) {
        logger.info(String.format("Index::index action called %d", count.incrementAndGet()));
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello, world!");
        return renderTemplate(new ModelAndView(attributes, "./templates/web/home/index.html"));
    }
}
