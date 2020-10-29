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

package com.liferay.osb.commerce.provisioning.internal.cloud.client;

import com.liferay.osb.commerce.provisioning.internal.cloud.client.dto.PortalInstance;
import com.liferay.portal.instances.initializer.PortalInstanceInitializer;
import com.liferay.portal.instances.initializer.PortalInstanceInitializerRegistry;
import com.liferay.portal.instances.service.PortalInstancesLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivica Cardic
 */
public class DXPCloudProvisioningClientMockImpl
	implements DXPCloudProvisioningClient {

	public DXPCloudProvisioningClientMockImpl(
		CompanyLocalService companyLocalService,
		PortalInstanceInitializerRegistry portalInstanceInitializerRegistry,
		PortalInstancesLocalService portalInstancesLocalService) {

		_companyLocalService = companyLocalService;
		_portalInstanceInitializerRegistry = portalInstanceInitializerRegistry;
		_portalInstancesLocalService = portalInstancesLocalService;
	}

	@Override
	public void deletePortalInstance(String portalInstanceId) {
		try {
			Company company = _companyLocalService.getCompanyByWebId(
				portalInstanceId);

			_portalInstancesLocalService.removeCompany(company.getCompanyId());
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public PortalInstance getPortalInstance(String portalInstanceId) {
		try {
			return _getPortalInstance(portalInstanceId);
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}
	}

	@Override
	public List<PortalInstance> getPortalInstances() {
		List<PortalInstance> portalInstances = new ArrayList<>();

		long[] companyIds = _portalInstancesLocalService.getCompanyIds();

		for (long companyId : companyIds) {
			try {
				Company company = _companyLocalService.getCompany(companyId);

				portalInstances.add(_getPortalInstance(company.getWebId()));
			}
			catch (PortalException portalException) {
				throw new SystemException(portalException);
			}
		}

		return portalInstances;
	}

	@Override
	public PortalInstance postPortalInstance(
		String domain, String portalInitializerKey) {

		PortalInstanceInitializer portalInstanceInitializer =
			_portalInstanceInitializerRegistry.getPortalInstanceInitializer(
				portalInitializerKey);

		String webId = _generateWebId();

		String virtualHostname = _toVirtualHostname(webId);

		try {
			portalInstanceInitializer.initialize(
				webId, virtualHostname, domain);

			return _getPortalInstance(webId);
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}
	}

	@Override
	public PortalInstance updatePortalInstance(
		String domain, String portalInstanceId) {

		try {
			Company company = _companyLocalService.getCompanyByWebId(
				portalInstanceId);

			company.setMx(domain);

			_companyLocalService.updateCompany(company);

			return _toPortalInstance(company);
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}
	}

	private String _generateWebId() {
		return "commerce" + (_companyLocalService.getCompaniesCount() + 1);
	}

	private PortalInstance _getPortalInstance(String webId)
		throws PortalException {

		Company company = _companyLocalService.getCompanyByWebId(webId);

		return _toPortalInstance(company);
	}

	private PortalInstance _toPortalInstance(Company company) {
		PortalInstance portalInstance = new PortalInstance();

		portalInstance.setDomain(company.getMx());
		portalInstance.setVirtualHost(company.getVirtualHostname());
		portalInstance.setPortalInstanceId(company.getWebId());

		return portalInstance;
	}

	private String _toVirtualHostname(String webId) {
		return webId + ".test";
	}

	private final CompanyLocalService _companyLocalService;
	private final PortalInstanceInitializerRegistry
		_portalInstanceInitializerRegistry;
	private final PortalInstancesLocalService _portalInstancesLocalService;

}