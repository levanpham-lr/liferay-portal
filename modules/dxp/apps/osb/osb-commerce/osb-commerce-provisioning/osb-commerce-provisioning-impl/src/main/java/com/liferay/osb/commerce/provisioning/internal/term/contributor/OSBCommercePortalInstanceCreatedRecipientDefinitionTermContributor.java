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

package com.liferay.osb.commerce.provisioning.internal.term.contributor;

import com.liferay.commerce.account.constants.CommerceAccountConstants;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.model.CommerceAccountUserRel;
import com.liferay.commerce.account.service.CommerceAccountUserRelLocalService;
import com.liferay.commerce.constants.CommerceDefinitionTermConstants;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.model.CommerceSubscriptionEntry;
import com.liferay.commerce.order.CommerceDefinitionTermContributor;
import com.liferay.commerce.service.CommerceOrderItemLocalService;
import com.liferay.osb.commerce.provisioning.constants.OSBCommerceNotificationConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ivica Cardic
 */
@Component(
	immediate = true,
	property = {
		"commerce.definition.term.contributor.key=" + OSBCommercePortalInstanceCreatedRecipientDefinitionTermContributor.KEY,
		"commerce.notification.type.key=" + OSBCommerceNotificationConstants.PORTAL_INSTANCE_CREATED
	},
	service = CommerceDefinitionTermContributor.class
)
public class OSBCommercePortalInstanceCreatedRecipientDefinitionTermContributor
	implements CommerceDefinitionTermContributor {

	public static final String KEY =
		CommerceDefinitionTermConstants.RECIPIENT_DEFINITION_TERMS_CONTRIBUTOR;

	@Override
	public Map<String, String> getDefinitionTerms(Locale locale) {
		Map<String, String> map = new HashMap<>();

		List<String> terms = getTerms();

		for (String term : terms) {
			map.put(term, getLabel(term, locale));
		}

		return map;
	}

	@Override
	public String getFilledTerm(String term, Object object, Locale locale)
		throws PortalException {

		if (!(object instanceof CommerceSubscriptionEntry)) {
			return term;
		}

		CommerceSubscriptionEntry commerceSubscriptionEntry =
			(CommerceSubscriptionEntry)object;

		if (term.equals(_ACCOUNT_ROLE_ADMINISTRATOR)) {
			CommerceOrderItem commerceOrderItem =
				_commerceOrderItemLocalService.getCommerceOrderItem(
					commerceSubscriptionEntry.getCommerceOrderItemId());

			CommerceOrder commerceOrder = commerceOrderItem.getCommerceOrder();

			CommerceAccount commerceAccount =
				commerceOrder.getCommerceAccount();

			Role accountAdminRole = _roleLocalService.getRole(
				commerceOrder.getCompanyId(),
				CommerceAccountConstants.ROLE_NAME_ACCOUNT_ADMINISTRATOR);

			return _getUserIds(commerceAccount, accountAdminRole);
		}

		if (term.equals(_PORTAL_INSTANCE_CREATOR)) {
			return String.valueOf(commerceSubscriptionEntry.getUserId());
		}

		return term;
	}

	@Override
	public String getLabel(String term, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, _commerceOrderDefinitionTermsMap.get(term));
	}

	@Override
	public List<String> getTerms() {
		return new ArrayList<>(_commerceOrderDefinitionTermsMap.keySet());
	}

	private String _getUserIds(CommerceAccount commerceAccount, Role role)
		throws PortalException {

		StringBundler resultsSB = new StringBundler();

		List<CommerceAccountUserRel> commerceAccountUserRels =
			_commerceAccountUserRelLocalService.getCommerceAccountUserRels(
				commerceAccount.getCommerceAccountId());

		for (CommerceAccountUserRel commerceAccountUserRel :
				commerceAccountUserRels) {

			List<Role> userRoles = _roleLocalService.getUserGroupRoles(
				commerceAccountUserRel.getCommerceAccountUserId(),
				commerceAccount.getCommerceAccountGroupId());

			if (userRoles.contains(role)) {
				resultsSB.append(
					commerceAccountUserRel.getCommerceAccountUserId());
				resultsSB.append(",");
			}
		}

		return resultsSB.toString();
	}

	private static final String _ACCOUNT_ROLE_ADMINISTRATOR =
		"[%ACCOUNT_ROLE_ADMINISTRATOR%]";

	private static final String _PORTAL_INSTANCE_CREATOR =
		"[%PORTAL_INSTANCE_CREATOR%]";

	private static final Map<String, String> _commerceOrderDefinitionTermsMap =
		new HashMap<String, String>() {
			{
				put(
					_ACCOUNT_ROLE_ADMINISTRATOR,
					"account-role-administrator-definition-term");
				put(
					_PORTAL_INSTANCE_CREATOR,
					"portal-instance-creator-definition-term");
			}
		};

	@Reference
	private CommerceAccountUserRelLocalService
		_commerceAccountUserRelLocalService;

	@Reference
	private CommerceOrderItemLocalService _commerceOrderItemLocalService;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserLocalService _userLocalService;

}