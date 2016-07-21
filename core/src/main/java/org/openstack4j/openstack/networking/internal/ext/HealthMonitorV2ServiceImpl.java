package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.networking.ext.HealthMonitorV2Service;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.network.ext.HealthMonitorUpdateV2;
import org.openstack4j.model.network.ext.HealthMonitorV2;
import org.openstack4j.openstack.compute.functions.ToActionResponseFunction;
import org.openstack4j.openstack.networking.domain.ext.NeutronHealthMonitorV2;
import org.openstack4j.openstack.networking.domain.ext.NeutronHealthMonitorV2.HealthMonitorsV2;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * OpenStack (Neutron) lbaas v2 health monitor operations
 * @author ashleykasim
 */
public class HealthMonitorV2ServiceImpl extends BaseNetworkingServices implements HealthMonitorV2Service{
    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends HealthMonitorV2> list(){
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends HealthMonitorV2> list(Map<String, String> filteringParams){
        Invocation<HealthMonitorsV2> req = get(HealthMonitorsV2.class, uri("/lbaas/health_monitors"));
        if (filteringParams != null) {
            for (Map.Entry<String, String> entry : filteringParams.entrySet()) {
                req = req.param(entry.getKey(), entry.getValue());
            }
        }
        return req.execute().getList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HealthMonitorV2 get(String healthMonitorId){
        checkNotNull(healthMonitorId);
        return get(NeutronHealthMonitorV2.class, uri("/lbaas/health_monitors/%s", healthMonitorId)).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionResponse delete(String healthMonitorId){
        checkNotNull(healthMonitorId);
        return ToActionResponseFunction.INSTANCE.apply(delete(Void.class, uri("/lbaas/health_monitors/%s", healthMonitorId)).executeWithResponse());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HealthMonitorV2 create(HealthMonitorV2 healthMonitor){
        checkNotNull(healthMonitor);
        return post(NeutronHealthMonitorV2.class,uri("/lbaas/health_monitors")).entity(healthMonitor).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HealthMonitorV2 update(String healthMonitorId,
                                HealthMonitorUpdateV2 healthMonitor) {
        checkNotNull(healthMonitorId);
        checkNotNull(healthMonitor);
        return put(NeutronHealthMonitorV2.class,uri("/lbaas/health_monitors/%s",healthMonitorId)).entity(healthMonitor).execute();
    }
}
