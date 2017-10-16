package com.springcloud.consulclient.controller;

import com.springcloud.consulclient.used.FeinClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/11
 * @Time:15:14
 */
@RestController
public class ConsumerController {

    @Autowired
    private FeinClient feinClient;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping(value = "/clientName", method = RequestMethod.GET)
    public String add() {
        return loadBalancer.choose("serviceName").getUri().toString()+feinClient.test1();
    }

    @RequestMapping(value = "/clientDiffName", method = RequestMethod.GET)
    public String diffname() {
        return loadBalancer.choose("serviceName").getUri().toString()+feinClient.diffname();
    }

    @RequestMapping(value = "/clientParam", method = RequestMethod.GET)
    public String paramname(@RequestParam(value = "param") Integer param) {
        return loadBalancer.choose("serviceName").getUri().toString()+feinClient.paramname(param);
    }
}

