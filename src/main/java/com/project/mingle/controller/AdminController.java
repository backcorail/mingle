package com.project.mingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/admin")
public class AdminController {

	@GetMapping("")
	public String admin_main() {
		return "admin/admin_main";
	}

	@GetMapping("/members")
	public String admin_members() {
		return "admin/admin_members";
	}

	@GetMapping("/products")
	public String admin_products() {
		return "admin/admin_products";
	}

	@GetMapping("/transactions")
	public String admin_transactions() {
		return "admin/admin_transactions";
	}

	@GetMapping("/posts")
	public String admin_posts() {
		return "admin/admin_posts";
	}

	@GetMapping("/recommendations")
	public String admin_recommendations() {
		return "admin/admin_recommendations";
	}

	@GetMapping("/server")
	public String admin_server() {
		return "admin/admin_server";
	}
}
