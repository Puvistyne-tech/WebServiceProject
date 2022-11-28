/**
 * GustaveBikeService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package src;

public interface GustaveBikeService_PortType extends java.rmi.Remote {
    public java.lang.String getBikeDisponibility(java.lang.String bikeId) throws java.rmi.RemoteException;
    public java.lang.String addBikeToCart(java.lang.String bikeId) throws java.rmi.RemoteException;
    public java.lang.String displayAllBikes() throws java.rmi.RemoteException;
    public java.lang.String buyBike(java.lang.String bikeId) throws java.rmi.RemoteException;
}
