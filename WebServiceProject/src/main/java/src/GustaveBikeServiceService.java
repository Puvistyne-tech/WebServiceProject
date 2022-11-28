/**
 * GustaveBikeServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package src;

public interface GustaveBikeServiceService extends javax.xml.rpc.Service {
    public java.lang.String getGustaveBikeServiceAddress();

    public src.GustaveBikeService_PortType getGustaveBikeService() throws javax.xml.rpc.ServiceException;

    public src.GustaveBikeService_PortType getGustaveBikeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
