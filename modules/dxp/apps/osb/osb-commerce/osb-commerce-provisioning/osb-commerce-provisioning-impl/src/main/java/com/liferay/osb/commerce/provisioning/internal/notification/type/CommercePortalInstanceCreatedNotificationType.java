/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.osb.commerce.provisioning.internal.notification.type;

import com.liferay.commerce.model.CommerceSubscriptionEntry;
import com.liferay.commerce.notification.type.CommerceNotificationType;
import com.liferay.osb.commerce.provisioning.constants.OSBCommerceNotificationConstants;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ivica Cardic
 */
@Component(
	immediate = true,
	property = {
		"commerce.notification.type.key=" + OSBCommerceNotificationConstants.PORTAL_INSTANCE_CREATED,
		"commerce.notification.type.order:Integer=310"
	},
	service = CommerceNotificationType.class
)
public class CommercePortalInstanceCreatedNotificationType
	implements CommerceNotificationType {

	@Override
	public String getClassName(Object object) {
		if (!(object instanceof CommerceSubscriptionEntry)) {
			return null;
		}

		return CommerceSubscriptionEntry.class.getName();
	}

	@Override
	public long getClassPK(Object object) {
		if (!(object instanceof CommerceSubscriptionEntry)) {
			return 0;
		}

		CommerceSubscriptionEntry commerceSubscriptionEntry =
			(CommerceSubscriptionEntry)object;

		return commerceSubscriptionEntry.getCommerceSubscriptionEntryId();
	}

	@Override
	public String getKey() {
		return OSBCommerceNotificationConstants.PORTAL_INSTANCE_CREATED;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle,
			OSBCommerceNotificationConstants.PORTAL_INSTANCE_CREATED);
	}

}