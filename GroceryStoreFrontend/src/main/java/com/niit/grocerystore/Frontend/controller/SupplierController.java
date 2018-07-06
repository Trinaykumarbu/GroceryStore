package com.niit.grocerystore.Frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.grocerystore.Dao.SupplierDao;
import com.niit.grocerystore.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;

	@RequestMapping("/supplier")
	public ModelAndView Supplier()
	{
		ModelAndView mv= new ModelAndView("supplier1");
		mv.addObject("supplier", new Supplier());
		List<Supplier> suplist= supplierDao.list();
		mv.addObject("suppliers", suplist);
		return mv;
	}
	
	@RequestMapping("/addSupplier")
	public ModelAndView addsupplier(@ModelAttribute("supplier")Supplier supplier)
	{
		ModelAndView mv= new ModelAndView("redirect:/supplier");
		mv.addObject("supplier", supplier);
		if(supplierDao.saveorupdate(supplier)==true)
		{
			mv.addObject("msg5","Supplier is saved successfully");
		}
		else
		{
			mv.addObject("msg5","Supplier is not saved");
		}
		return mv;
	}
	
	@RequestMapping("/editSupplier/{supplierId}")
	public ModelAndView editsupplier(@PathVariable("supplierId")String supplierId)
	{
		ModelAndView mv= new ModelAndView("supplier1");
		supplier=supplierDao.getSupplier(supplierId);
		mv.addObject("supplier", supplier);
		List<Supplier> suplist= supplierDao.list();
		mv.addObject("suppliers", suplist);
		return mv;
	}
	
	@RequestMapping("/deleteSupplier/{supplierId}")
	public ModelAndView deletesupplier(@PathVariable("supplierId")String supplierid)
	{
		ModelAndView mv= new ModelAndView("redirect:/supplier");
		supplier= supplierDao.getSupplier(supplierid);
		if(supplierDao.delete(supplier)==true)
		{
			mv.addObject("msg6", "Supplier Deleted");
		}
		else
		{
			mv.addObject("msg6","Supplier not deleted");
		}
		return mv;
	}
}
