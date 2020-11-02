<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">
	<head>
		<title>${the_title} - ${company_name}</title>

		<meta content="initial-scale=1.0, width=device-width" name="viewport" />

		<@liferay_util["include"] page=top_head_include />
	</head>

	<body class="${css_class}">
		<#assign roles = user.getRoles()
			showcontrolmenu = false
		/>
		<#list roles as role>
			<#if role.getName() == "Administrator">
				<#assign showcontrolmenu = true />
				<#break>
			</#if>
		</#list>
		<#if showcontrolmenu>
			<@liferay_ui["quick-access"] contentId="#main-content" />
			<@liferay_util["include"] page=body_top_include />
			<@liferay.control_menu />
		</#if>

		<div class="container-fluid pt-0" id="wrapper">

			<#--<#if show_header>
				<#include "${full_templates_path}/header.ftl" />
			</#if>-->

			<main class="container-fluid" id="content" role="main">
				<h2 class="sr-only" role="heading" aria-level="1">${the_title}</h2>

				<div class="left-menu-panel open sidenav-fixed sidenav-menu-slider">
					<div class="left-menu sidebar sidenav-menu">
						<#if show_site_name>
							<h2 class="h2 ml-4 mt-3 mb-3 text-dark site-name" role="heading" aria-level="1">Admin</h2>
						</#if>

						<div class="left-menu-sidebar">
							<div class="sidebar-body">
								<#assign
									portlet_preferences = freeMarkerPortletPreferences.getPreferences({
										"portletSetupPortletDecoratorId": "barebone",
										"rootMenuItemType": "absolute",
										"rootMenuItemLevel": "0",
										"displayStyle": "ddmTemplate_NAV-PILLS-STACKED-FTL"
									})
								/>

								<@liferay_portlet["runtime"]
									defaultPreferences="${portlet_preferences}"
									instanceId="site_navigation_left_menu_navigation"
									portletName="com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet"
									portletProviderAction=portletProviderAction.VIEW
									portletProviderClassName="com.liferay.portal.kernel.theme.NavItem"
								/>

								<div>
									<div class="pl-3 pt-4 text-muted text-uppercase small">Channels</div>

									<ul class="nav nav-pills nav-stacked navbar-site">
										<li class="lfr-nav-item nav-item">
											<a class="nav-link text-truncate" href="/group/osb-commerce-instance-storefront" target="_blank">
												<span>Storefront</span>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>

						<div class="user-management">
							<@liferay.user_personal_bar />
						</div>
					</div>
				</div>

				<#if selectable>
					<@liferay_util["include"] page=content_include />
				<#else>
					${portletDisplay.recycle()}

					${portletDisplay.setTitle(the_title)}

					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
					</@>
				</#if>
			</main>

			<#--<#if show_footer>
				<#include "${full_templates_path}/footer.ftl" />
			</#if>-->

		</div>

	<@liferay_util["include"] page=body_bottom_include />

	<@liferay_util["include"] page=bottom_include />

	</body>
</html>