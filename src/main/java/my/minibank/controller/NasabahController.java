package my.minibank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.minibank.model.NasabahModel;
import my.minibank.service.NasabahService;

@Controller
public class NasabahController {
	
	@Autowired
	private NasabahService nasabahService;
	
	@GetMapping("/halo/{name}")
	public String nama(@PathVariable String name, ModelMap model) {
		String sapa = "Hello !!! " + name + ", Welcome !";
		model.addAttribute("salam", sapa);
		System.out.println(sapa);
		
		return "hello";
	}
	
	@RequestMapping(path= "hi/{name}", method=RequestMethod.GET)
	public String sapa2(@PathVariable String name, ModelMap model) {
		String sapa = "Haiiii !!!" + name + " Selamat Datang!";
		model.addAttribute("salam", sapa);
		System.out.println(sapa);
		
		return "hello";
	}
	
	@RequestMapping(path="/listN", method=RequestMethod.GET)
	public String listNasabah(Model modelx) {
		List<NasabahModel> nasabahX = nasabahService.getNasabah();
		modelx.addAttribute("nasabahh", nasabahX);
		
		return "list-customers";
	}

}
