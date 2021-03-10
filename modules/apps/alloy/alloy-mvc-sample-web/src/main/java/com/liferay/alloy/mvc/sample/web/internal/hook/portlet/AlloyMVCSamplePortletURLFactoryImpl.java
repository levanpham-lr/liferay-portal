/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.alloy.mvc.sample.web.internal.hook.portlet;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.model.impl.VirtualLayout;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.pacl.DoPrivileged;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = PortletURLFactory.class)
@DoPrivileged
public class AlloyMVCSamplePortletURLFactoryImpl implements PortletURLFactory {

	@Activate
	public void activate() throws Exception {
		_originalPortletURLFactory =
			PortletURLFactoryUtil.getPortletURLFactory();

		PortletURLFactoryUtil portletURLFactoryUtil =
			new PortletURLFactoryUtil();

		portletURLFactoryUtil.setPortletURLFactory(this);
	}

	public LiferayPortletURL create(
		HttpServletRequest request, Portlet portlet, Layout layout,
		String lifecycle) {

		return new AlloyMVCSamplePortletURLWrapper(
			request, portlet, layout, lifecycle);
	}

	public LiferayPortletURL create(
		HttpServletRequest request, Portlet portlet, String lifecycle) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (layout == null) {
			layout = _getLayout(
				(Layout)request.getAttribute(WebKeys.LAYOUT),
				themeDisplay.getPlid());
		}

		return new AlloyMVCSamplePortletURLWrapper(
			request, portlet, layout, lifecycle);
	}

	@Override
	public LiferayPortletURL create(
		HttpServletRequest request, String portletId, Layout layout,
		String lifecycle) {

		return new AlloyMVCSamplePortletURLWrapper(
			request, portletId, layout, lifecycle);
	}

	@Override
	public LiferayPortletURL create(
		HttpServletRequest request, String portletId, long plid,
		String lifecycle) {

		return new AlloyMVCSamplePortletURLWrapper(
			request, portletId, plid, lifecycle);
	}

	public LiferayPortletURL create(
		HttpServletRequest request, String portletId, String lifecycle) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (layout != null) {
			return new AlloyMVCSamplePortletURLWrapper(
				request, portletId, layout, lifecycle);
		}

		return new AlloyMVCSamplePortletURLWrapper(
			request, portletId, themeDisplay.getPlid(), lifecycle);
	}

	public LiferayPortletURL create(
		PortletRequest portletRequest, Portlet portlet, Layout layout,
		String lifecycle) {

		return new AlloyMVCSamplePortletURLWrapper(
			portletRequest, portlet, layout, lifecycle);
	}

	public LiferayPortletURL create(
		PortletRequest portletRequest, Portlet portlet, long plid,
		String lifecycle) {

		return new AlloyMVCSamplePortletURLWrapper(
			portletRequest, portlet,
			_getLayout(
				(Layout)portletRequest.getAttribute(WebKeys.LAYOUT), plid),
			lifecycle);
	}

	@Override
	public LiferayPortletURL create(
		PortletRequest portletRequest, String portletId, Layout layout,
		String lifecycle) {

		return new AlloyMVCSamplePortletURLWrapper(
			portletRequest, portletId, layout, lifecycle);
	}

	@Override
	public LiferayPortletURL create(
		PortletRequest portletRequest, String portletId, long plid,
		String lifecycle) {

		return new AlloyMVCSamplePortletURLWrapper(
			portletRequest, portletId, plid, lifecycle);
	}

	public LiferayPortletURL create(
		PortletRequest portletRequest, String portletId, String lifecycle) {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (layout != null) {
			return new AlloyMVCSamplePortletURLWrapper(
				portletRequest, portletId, layout, lifecycle);
		}

		return new AlloyMVCSamplePortletURLWrapper(
			portletRequest, portletId, themeDisplay.getPlid(), lifecycle);
	}

	@Deactivate
	public void deactivate() {
		PortletURLFactoryUtil portletURLFactoryUtil =
			new PortletURLFactoryUtil();

		portletURLFactoryUtil.setPortletURLFactory(_originalPortletURLFactory);
	}

	private Layout _getLayout(Layout layout, long plid) {
		if ((layout != null) && (layout.getPlid() == plid) &&
			(layout instanceof VirtualLayout)) {

			return layout;
		}

		if (plid > 0) {
			return _layoutLocalService.fetchLayout(plid);
		}

		return null;
	}

	@Reference
	private LayoutLocalService _layoutLocalService;

	private PortletURLFactory _originalPortletURLFactory;

}