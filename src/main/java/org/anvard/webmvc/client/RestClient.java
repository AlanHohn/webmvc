package org.anvard.webmvc.client;

import org.anvard.webmvc.api.Calculation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;


public class RestClient {

    private RestTemplate tmpl;
    private String host;
    private String port;

    public Calculation calc(String op, int left, int right) {
        return tmpl.getForObject(getUrlRoot() + "rest/calc/{op}/{left}/{right}", Calculation.class, op, left, right);
    }
    
    public Calculation calc2(Calculation in) {
        return tmpl.postForObject(getUrlRoot() + "rest/calc2", in, Calculation.class);
    }
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/clientContext.xml");
        RestClient client = (RestClient) ctx.getBean("client");
        client.print(client.calc("add", 2, 2));
        client.print(client.calc("subtract", 20, 2));
        client.print(client.calc("multiply", 5, 3));
        client.print(client.calc("divide", 20, 2));
        
        client.print(client.calc2(new Calculation("add", 50, 50)));
        client.print(client.calc2(new Calculation("subtract", 60, 40)));
        client.print(client.calc2(new Calculation("multiply", 25, 12)));
        client.print(client.calc2(new Calculation("divide", 16, 5)));
    }
    
    public void print(Calculation c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c.getLeft());
        String op = c.getOperation();
        if (op.equalsIgnoreCase("subtract")) {
            sb.append(" - ");
        } else if (op.equalsIgnoreCase("multiply")) {
            sb.append(" * ");
        } else if (op.equalsIgnoreCase("divide")) {
            sb.append(" / ");
        } else {
            sb.append(" + ");
        }
        sb.append(c.getRight());
        sb.append(" = ");
        sb.append(c.getResult());
        System.out.println(sb.toString());
    }
    
    private String getUrlRoot() {
    	return "http://" + host + ":" + port + "/";
    }
    
    public void setTmpl(RestTemplate tmpl) {
        this.tmpl = tmpl;
    }

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}
    
}
