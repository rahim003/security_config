package kurbanov.restapiwork.dto.conver;

public interface Convert <MODEL,REQUEST,RESPONSE>{

    MODEL convert(REQUEST request);

    RESPONSE deConvert(MODEL model);
}
