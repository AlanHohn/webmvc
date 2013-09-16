package org.anvard.webmvc.server;

import org.anvard.webmvc.api.Calculation;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Calculator {

    @RequestMapping(value = "/calc/{op}/{left}/{right}", method = RequestMethod.GET)
    @ResponseBody
    public Calculation calculate(@PathVariable("op") String op, @PathVariable("left") Integer left,
            @PathVariable("right") Integer right) {
        Assert.notNull(op);
        Assert.notNull(left);
        Assert.notNull(right);
        Calculation result = new Calculation();
        result.setOperation(op);
        result.setLeft(left);
        result.setRight(right);
        return doCalc(result);
    }

    @RequestMapping(value = "/calc2", method = RequestMethod.POST)
    @ResponseBody
    public Calculation calculate(@RequestBody Calculation calc) {
        Assert.notNull(calc);
        Assert.notNull(calc.getOperation());
        Assert.notNull(calc.getLeft());
        Assert.notNull(calc.getRight());
        return doCalc(calc);
    }

    private Calculation doCalc(Calculation c) {
        String op = c.getOperation();
        int left = c.getLeft();
        int right = c.getRight();
        if (op.equalsIgnoreCase("subtract")) {
            c.setResult(left - right);
        } else if (op.equalsIgnoreCase("multiply")) {
            c.setResult(left * right);
        } else if (op.equalsIgnoreCase("divide")) {
            c.setResult(left / right);
        } else {
            c.setResult(left + right);
        }
        return c;
    }
    
}
