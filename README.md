# soap-example
Url: http://localhost:8080/ws
Create country:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ude="http://udem.edu.co/isv/ejemplo-soap">
   <soapenv:Header/>
   <soapenv:Body>
      <ude:createCountryRequest>
         <ude:country>
            <ude:name>Peru</ude:name>
            <ude:population>32971846</ude:population>
            <ude:capital>Lima</ude:capital>
            <ude:currency>PEN</ude:currency>
         </ude:country>
      </ude:createCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>

List country:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ude="http://udem.edu.co/isv/ejemplo-soap">
   <soapenv:Header/>
   <soapenv:Body>
      <ude:listCountriesRequest/>
   </soapenv:Body>
</soapenv:Envelope>

Delete country:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xs="http://udem.edu.co/isv/ejemplo-soap">
   <soapenv:Header/>
   <soapenv:Body>
      <xs:deleteCountryRequest>
         <xs:name>Spain</xs:name>
      </xs:deleteCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>
