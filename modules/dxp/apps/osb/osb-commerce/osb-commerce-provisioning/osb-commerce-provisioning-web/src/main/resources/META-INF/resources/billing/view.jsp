<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
CommerceAccountDisplayContext commerceAccountDisplayContext = (CommerceAccountDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

CommerceAccount commerceAccount = commerceAccountDisplayContext.getCurrentCommerceAccount();
List<CommerceCountry> commerceCountries = commerceAccountDisplayContext.getCommerceCountries(company.getCompanyId());
%>

<portlet:actionURL name="editCommerceAccount" var="editCommerceAccountActionURL" />

<div class="account-management mt-3">
	<aui:form action="<%= editCommerceAccountActionURL %>" method="post" name="fm">
		<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
		<aui:input name="commerceAccountId" type="hidden" value="<%= commerceAccount.getCommerceAccountId() %>" />

		<liferay-ui:error-marker
			key="<%= WebKeys.ERROR_SECTION %>"
			value="details"
		/>

		<aui:model-context bean="<%= commerceAccount %>" model="<%= CommerceAccount.class %>" />

		<div class="row">
			<div class="col-lg-8">
				<aui:input name="name" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-8">
				<aui:input name="email" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-8">
				<aui:input label="vat-number" name="taxId" />
			</div>
		</div>

		<aui:model-context bean="<%= commerceAccountDisplayContext.getBillingCommerceAddress() %>" model="<%= CommerceAddress.class %>" />

		<div class="row">
			<div class="col-lg-8">
				<aui:input label="address" name="street1" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<aui:select label="country" name="commerceCountryId">

					<%
					for (CommerceCountry commerceCountry : commerceCountries) {
					%>

						<aui:option value="<%= commerceCountry.getCommerceCountryId() %>">
							<%= commerceCountry.getName(locale) %>
						</aui:option>

					<%
					}
					%>

				</aui:select>
			</div>

			<div class="col-lg-4">
				<aui:input label="region" name="commerceRegionId" />
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<aui:input label="city" name="city" />
			</div>

			<div class="col-lg-4">
				<aui:input label="zip" name="zip" />
			</div>
		</div>

		<div class="commerce-cta is-visible">
			<aui:button cssClass="btn-lg" primary="<%= true %>" type="submit" />
		</div>
	</aui:form>
</div>