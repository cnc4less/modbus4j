package br.com.eits.modbus;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.ip.tcp.TcpMaster;
import com.serotonin.modbus4j.locator.BaseLocator;

/**
 * Hello world!
 *
 */
public class MasterMain 
{
    public static void main( String[] args ) throws ModbusInitException, ModbusTransportException, ErrorResponseException, InterruptedException
    {
    	final IpParameters ipParameters = new IpParameters();
    	ipParameters.setHost("179.106.230.167");//fto
        ipParameters.setPort(9999);
        
        final ModbusFactory modbusFactory = new ModbusFactory();
        final TcpMaster master = (TcpMaster) modbusFactory.createTcpMaster( ipParameters, true );
        master.init();
        
        /*
        final BatchRead<String> batchRead = new BatchRead<>();
        batchRead.addLocator("Potência AC - W", BaseLocator.holdingRegister(1, 40090, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        batchRead.addLocator("Frequência - Hz - ", BaseLocator.holdingRegister(1, 40092, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        
        batchRead.addLocator("Fator de Potência - % ", BaseLocator.holdingRegister(1, 40098, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        
        batchRead.addLocator("Tensão AC - V", BaseLocator.holdingRegister(1, 40084, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        batchRead.addLocator("Corrente AC - A", BaseLocator.holdingRegister(1, 40072, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        batchRead.addLocator("Potência Reativa - VAr", BaseLocator.holdingRegister(1, 40096, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        batchRead.addLocator("Potência Aparente - VA", BaseLocator.holdingRegister(1, 40094, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        
        batchRead.addLocator("Corrente DC - A", BaseLocator.holdingRegister(1, 40102, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        batchRead.addLocator("Tensão DC - V", BaseLocator.holdingRegister(1, 40104, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        batchRead.addLocator("Potência DC - W", BaseLocator.holdingRegister(1, 40106, DataType.FOUR_BYTE_FLOAT_SWAPPED));
        
        batchRead.addLocator("Situacao", BaseLocator.holdingRegister(1, 40118, DataType.TWO_BYTE_INT_SIGNED));
        
        batchRead.addLocator("Energia/Dia - Wh", BaseLocator.holdingRegister(1, 501, DataType.EIGHT_BYTE_INT_SIGNED));
        batchRead.addLocator("Energia/Ano - Wh", BaseLocator.holdingRegister(1, 505, DataType.EIGHT_BYTE_INT_SIGNED));
        batchRead.addLocator("Energia Total - Wh", BaseLocator.holdingRegister(1, 509, DataType.EIGHT_BYTE_INT_SIGNED));
        
        final BatchResults<String> results = master.send( batchRead );
        System.out.println(results);	
        */
        
        
        //ESCREVER 
        master.setValue( BaseLocator.holdingRegister(1, 40242, DataType.TWO_BYTE_INT_UNSIGNED), 10000 );
        //master.setValue( BaseLocator.holdingRegister(1, 40241, DataType.TWO_BYTE_INT_UNSIGNED), 1 );
        master.setValue( BaseLocator.holdingRegister(1, 40246, DataType.TWO_BYTE_INT_UNSIGNED), 1 );
        
        
        final BatchRead<String> batchRead = new BatchRead<>();
//    	batchRead.addLocator("Length of Immediate Controls: "+40238, BaseLocator.holdingRegister(1, 40238, DataType.TWO_BYTE_INT_UNSIGNED));
//    	batchRead.addLocator("Conn_WinTms: "+40239, BaseLocator.holdingRegister(1, 40239, DataType.TWO_BYTE_INT_UNSIGNED));
//    	batchRead.addLocator("Conn_RvrtTms: "+40240, BaseLocator.holdingRegister(1, 40240, DataType.TWO_BYTE_INT_UNSIGNED));
//        batchRead.addLocator("Connection Control: "+40241, BaseLocator.holdingRegister(1, 40241, DataType.TWO_BYTE_INT_UNSIGNED));
    	batchRead.addLocator("WMaxLimPct: "+40242, BaseLocator.holdingRegister(1, 40242, DataType.TWO_BYTE_INT_UNSIGNED));
    	batchRead.addLocator("WMaxLim_Ena: "+40246, BaseLocator.holdingRegister(1, 40246, DataType.TWO_BYTE_INT_UNSIGNED));
//    	batchRead.addLocator("WMaxLimPct_WinTms: "+40243, BaseLocator.holdingRegister(1, 40243, DataType.TWO_BYTE_INT_UNSIGNED));
    	
//    	batchRead.addLocator("WMaxLimPct_SF: "+40260, BaseLocator.holdingRegister(1, 40260, DataType.TWO_BYTE_INT_SIGNED));
//    	batchRead.addLocator("OutPFSet_SF: "+40261, BaseLocator.holdingRegister(1, 40261, DataType.TWO_BYTE_INT_SIGNED));
//    	batchRead.addLocator("VArPct_SF: "+40262, BaseLocator.holdingRegister(1, 40262, DataType.TWO_BYTE_INT_SIGNED));
    	
    	final BatchResults<String> results = master.send( batchRead );
    	System.out.println(results);
    	
        
    	
        /*
        for (int i = 40075; i < 40110; i++) {
        	 final BatchRead<String> batchRead = new BatchRead<>();
         	batchRead.addLocator(String.valueOf(i), BaseLocator.holdingRegister(1, i, DataType.FOUR_BYTE_FLOAT));
         	
         	final BatchResults<String> results = master.send( batchRead );
            System.out.println(results);	
		}
		*/
        
        //final BaseLocator baseLocator = BaseLocator.holdingRegister(50, 216, DataType.TWO_BYTE_INT_UNSIGNED);
        //master.setValue(baseLocator, 10);
    }
}
