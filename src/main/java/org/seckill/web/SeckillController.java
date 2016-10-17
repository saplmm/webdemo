package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by saplmm on 2016/10/17.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private SeckillServie seckillServie;

    @RequestMapping(name = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> list = seckillServie.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }


    @RequestMapping(value = "/{seckillId}detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }

        Seckill seckill = seckillServie.getByUd(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    //ajax return json

    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {"application/json", "charset/utf-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(Long seckillId) {

        SeckillResult<Exposer> result;
        Exposer exposer = seckillServie.exportSeckillUrl(seckillId);
        result = new SeckillResult<Exposer>();
        result.setSuccess(true);
        result.setData(exposer);
        return result;

    }
}
