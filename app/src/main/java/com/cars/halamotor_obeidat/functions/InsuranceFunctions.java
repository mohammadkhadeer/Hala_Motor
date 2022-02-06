package com.cars.halamotor_obeidat.functions;

import android.content.Context;
import android.database.Cursor;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.dataBase.DBHelper;
import com.cars.halamotor_obeidat.model.CarInformation;
import com.cars.halamotor_obeidat.model.CarProcess;
import com.cars.halamotor_obeidat.model.CertificateClaims;
import com.cars.halamotor_obeidat.model.CityModel;
import com.cars.halamotor_obeidat.model.CylinderNumber;
import com.cars.halamotor_obeidat.model.DriverInformation;
import com.cars.halamotor_obeidat.model.DriverProcess;
import com.cars.halamotor_obeidat.model.LicenseDuration;
import com.cars.halamotor_obeidat.model.License_Nationality;
import com.cars.halamotor_obeidat.model.Nationality;
import com.cars.halamotor_obeidat.model.ProcessContent;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.checkIfCarDetailsProcessCreated;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.checkIfDriverProcessCreated;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getAllDriverProcess;

public class InsuranceFunctions {

    public static License_Nationality getLicenseNationality(String nationality ,Context context)
    {
        License_Nationality licenseNationality=null;

        if (nationality.equals(context.getResources().getString(R.string.Afghan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Afghanistan),context.getResources().getString(R.string.Afghanistan_s));

        if (nationality.equals(context.getResources().getString(R.string.Albanian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Albania),context.getResources().getString(R.string.Albania_s));

        if (nationality.equals(context.getResources().getString(R.string.Algerian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Algeria),context.getResources().getString(R.string.Algeria_s));

        if (nationality.equals(context.getResources().getString(R.string.Argentine_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Argentina),context.getResources().getString(R.string.Argentina_s));

        if (nationality.equals(context.getResources().getString(R.string.Australian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Australia),context.getResources().getString(R.string.Australia_s));

        if (nationality.equals(context.getResources().getString(R.string.Austrian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Austria),context.getResources().getString(R.string.Austria));

        if (nationality.equals(context.getResources().getString(R.string.Bangladeshi_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Bangladesh),context.getResources().getString(R.string.Bangladesh));

        if (nationality.equals(context.getResources().getString(R.string.Belgian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Belgium),context.getResources().getString(R.string.Belgium_s));

        if (nationality.equals(context.getResources().getString(R.string.Bolivian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Bolivia),context.getResources().getString(R.string.Bolivia_s));

        if (nationality.equals(context.getResources().getString(R.string.Batswana_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Botswana),context.getResources().getString(R.string.Botswana_s));

        if (nationality.equals(context.getResources().getString(R.string.Brazilian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Brazil),context.getResources().getString(R.string.Brazil_s));

        if (nationality.equals(context.getResources().getString(R.string.Bulgarian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Bulgaria),context.getResources().getString(R.string.Bulgaria_s));

        if (nationality.equals(context.getResources().getString(R.string.Cambodian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Cambodia),context.getResources().getString(R.string.Cambodia_s));

        if (nationality.equals(context.getResources().getString(R.string.Cameroonian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Cameroon),context.getResources().getString(R.string.Cameroon_s));








        if (nationality.equals(context.getResources().getString(R.string.Canadian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Canada),context.getResources().getString(R.string.Canada_s));

        if (nationality.equals(context.getResources().getString(R.string.Chilean_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Chile),context.getResources().getString(R.string.Chile_s));

        if (nationality.equals(context.getResources().getString(R.string.Chinese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.China),context.getResources().getString(R.string.China_s));

        if (nationality.equals(context.getResources().getString(R.string.Colombian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Colombia),context.getResources().getString(R.string.Colombia_s));

        if (nationality.equals(context.getResources().getString(R.string.Costa_Rican_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Costa_Rica),context.getResources().getString(R.string.Costa_Rica_s));

        if (nationality.equals(context.getResources().getString(R.string.Croatian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Croatia),context.getResources().getString(R.string.Croatia_s));

        if (nationality.equals(context.getResources().getString(R.string.Cuban_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Cuba),context.getResources().getString(R.string.Cuba_s));

        if (nationality.equals(context.getResources().getString(R.string.Czech_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Czech_Republic),context.getResources().getString(R.string.Czech_Republic_s));

        if (nationality.equals(context.getResources().getString(R.string.Danish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Denmark),context.getResources().getString(R.string.Denmark_s));

        if (nationality.equals(context.getResources().getString(R.string.Dominican_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Dominican_Republic),context.getResources().getString(R.string.Dominican_Republic_s));

        if (nationality.equals(context.getResources().getString(R.string.Ecuadorian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Ecuador),context.getResources().getString(R.string.Ecuador_s));

        if (nationality.equals(context.getResources().getString(R.string.Egyptian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Egypt),context.getResources().getString(R.string.Egypt_s));

        if (nationality.equals(context.getResources().getString(R.string.Salvadorian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.El_Salvador),context.getResources().getString(R.string.El_Salvador_s));

        if (nationality.equals(context.getResources().getString(R.string.English_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.England),context.getResources().getString(R.string.England_s));

        if (nationality.equals(context.getResources().getString(R.string.Estonian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Estonia),context.getResources().getString(R.string.Estonia_s));

        if (nationality.equals(context.getResources().getString(R.string.Ethiopian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Ethiopia),context.getResources().getString(R.string.Ethiopia_s));

        if (nationality.equals(context.getResources().getString(R.string.Fijian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Fiji),context.getResources().getString(R.string.Fiji_s));

        if (nationality.equals(context.getResources().getString(R.string.Finnish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Finland),context.getResources().getString(R.string.Finland_s));

        if (nationality.equals(context.getResources().getString(R.string.French_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.France),context.getResources().getString(R.string.France_s));

        if (nationality.equals(context.getResources().getString(R.string.German_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Germany),context.getResources().getString(R.string.Germany_s));

        if (nationality.equals(context.getResources().getString(R.string.Ghanaian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Ghana),context.getResources().getString(R.string.Ghana_s));

        if (nationality.equals(context.getResources().getString(R.string.Greek_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Greece),context.getResources().getString(R.string.Greece_s));

        if (nationality.equals(context.getResources().getString(R.string.Guatemalan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Guatemala),context.getResources().getString(R.string.Guatemala_s));

        if (nationality.equals(context.getResources().getString(R.string.Haitian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Haiti),context.getResources().getString(R.string.Haiti_s));

        if (nationality.equals(context.getResources().getString(R.string.Honduran_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Honduras),context.getResources().getString(R.string.Honduras_s));

        if (nationality.equals(context.getResources().getString(R.string.Hungarian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Hungary),context.getResources().getString(R.string.Hungary_s));

        if (nationality.equals(context.getResources().getString(R.string.Icelandic_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Iceland),context.getResources().getString(R.string.Iceland_s));

        if (nationality.equals(context.getResources().getString(R.string.Indian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.India),context.getResources().getString(R.string.India_s));

        if (nationality.equals(context.getResources().getString(R.string.Indonesian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Indonesia),context.getResources().getString(R.string.Indonesia_s));

        if (nationality.equals(context.getResources().getString(R.string.Iranian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Iran),context.getResources().getString(R.string.Iran_s));

        if (nationality.equals(context.getResources().getString(R.string.Iraqi_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Iraq),context.getResources().getString(R.string.Iraq_s));

        if (nationality.equals(context.getResources().getString(R.string.Irish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Ireland),context.getResources().getString(R.string.Ireland_s));

        if (nationality.equals(context.getResources().getString(R.string.Italian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Italy),context.getResources().getString(R.string.Italy_s));

        if (nationality.equals(context.getResources().getString(R.string.Israeli_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Israel),context.getResources().getString(R.string.Israel_s));

        if (nationality.equals(context.getResources().getString(R.string.Jamaican_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Jamaica),context.getResources().getString(R.string.Jamaica_s));

        if (nationality.equals(context.getResources().getString(R.string.Japanese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Japan),context.getResources().getString(R.string.Japan_s));

        if (nationality.equals(context.getResources().getString(R.string.Jordanian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Jordan),context.getResources().getString(R.string.Jordan_s));

        if (nationality.equals(context.getResources().getString(R.string.Kenyan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Kenya),context.getResources().getString(R.string.Kenya_s));

        if (nationality.equals(context.getResources().getString(R.string.Kuwaiti_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Kuwait),context.getResources().getString(R.string.Kuwait_s));

        if (nationality.equals(context.getResources().getString(R.string.Lao_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Laos),context.getResources().getString(R.string.Laos_s));

        if (nationality.equals(context.getResources().getString(R.string.Latvian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Latvia),context.getResources().getString(R.string.Latvia_s));

        if (nationality.equals(context.getResources().getString(R.string.Lebanese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Lebanon),context.getResources().getString(R.string.Lebanon_s));

        if (nationality.equals(context.getResources().getString(R.string.Libyan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Libya),context.getResources().getString(R.string.Libya_s));

        if (nationality.equals(context.getResources().getString(R.string.Lithuanian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Lithuania),context.getResources().getString(R.string.Lithuania_s));

        if (nationality.equals(context.getResources().getString(R.string.Malagasy_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Madagascar),context.getResources().getString(R.string.Madagascar_s));

        if (nationality.equals(context.getResources().getString(R.string.Malian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Malaysia),context.getResources().getString(R.string.Malaysia_s));

        if (nationality.equals(context.getResources().getString(R.string.Maltese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Mali),context.getResources().getString(R.string.Mali_s));

        if (nationality.equals(context.getResources().getString(R.string.Maltese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Malta),context.getResources().getString(R.string.Malta));

        if (nationality.equals(context.getResources().getString(R.string.Mexican_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Mexico),context.getResources().getString(R.string.Mexico));

        if (nationality.equals(context.getResources().getString(R.string.Mongolian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Mongolia),context.getResources().getString(R.string.Mongolia_s));

        if (nationality.equals(context.getResources().getString(R.string.Moroccan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Morocco),context.getResources().getString(R.string.Morocco_s));

        if (nationality.equals(context.getResources().getString(R.string.Mozambican_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Mozambique),context.getResources().getString(R.string.Mozambique_s));

        if (nationality.equals(context.getResources().getString(R.string.Namibian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Namibia),context.getResources().getString(R.string.Namibia_s));

        if (nationality.equals(context.getResources().getString(R.string.Nepalese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Nepal),context.getResources().getString(R.string.Nepal_s));

        if (nationality.equals(context.getResources().getString(R.string.Dutch_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Netherlands),context.getResources().getString(R.string.Netherlands_s));

        if (nationality.equals(context.getResources().getString(R.string.New_Zealand_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.New_Zealand_c),context.getResources().getString(R.string.New_Zealand_c_s));

        if (nationality.equals(context.getResources().getString(R.string.Nicaraguan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Nicaragua),context.getResources().getString(R.string.Nicaragua_s));

        if (nationality.equals(context.getResources().getString(R.string.Nigerian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Nigeria),context.getResources().getString(R.string.Nigeria_s));

        if (nationality.equals(context.getResources().getString(R.string.Norwegian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Norway),context.getResources().getString(R.string.Norway_s));

        if (nationality.equals(context.getResources().getString(R.string.Pakistani_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Pakistan),context.getResources().getString(R.string.Pakistan_s));

        if (nationality.equals(context.getResources().getString(R.string.Panamanian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Panama),context.getResources().getString(R.string.Panama_s));

        if (nationality.equals(context.getResources().getString(R.string.Paraguayan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Paraguay),context.getResources().getString(R.string.Paraguay_s));

        if (nationality.equals(context.getResources().getString(R.string.Peruvian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Peru),context.getResources().getString(R.string.Peru_s));

        if (nationality.equals(context.getResources().getString(R.string.Philippine_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Philippines),context.getResources().getString(R.string.Philippines_s));

        if (nationality.equals(context.getResources().getString(R.string.Polish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Poland),context.getResources().getString(R.string.Poland_s));

        if (nationality.equals(context.getResources().getString(R.string.Portuguese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Portugal),context.getResources().getString(R.string.Portugal_s));

        if (nationality.equals(context.getResources().getString(R.string.Romanian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Romania),context.getResources().getString(R.string.Romania_s));

        if (nationality.equals(context.getResources().getString(R.string.Russian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Russia),context.getResources().getString(R.string.Russia_s));

        if (nationality.equals(context.getResources().getString(R.string.Saudi_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Saudi_Arabia),context.getResources().getString(R.string.Saudi_Arabia_s));

        if (nationality.equals(context.getResources().getString(R.string.Scottish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Scotland),context.getResources().getString(R.string.Scotland_s));

        if (nationality.equals(context.getResources().getString(R.string.Senegalese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Senegal),context.getResources().getString(R.string.Senegal_s));

        if (nationality.equals(context.getResources().getString(R.string.Serbian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Serbia),context.getResources().getString(R.string.Serbia_s));

        if (nationality.equals(context.getResources().getString(R.string.Singaporean_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Singapore),context.getResources().getString(R.string.Singapore_s));

        if (nationality.equals(context.getResources().getString(R.string.Slovak_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Slovakia),context.getResources().getString(R.string.Slovakia_s));

        if (nationality.equals(context.getResources().getString(R.string.South_African_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.South_Africa),context.getResources().getString(R.string.South_Africa_s));

        if (nationality.equals(context.getResources().getString(R.string.Korean_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.South_Korea),context.getResources().getString(R.string.South_Korea_s));

        if (nationality.equals(context.getResources().getString(R.string.Spanish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Spain),context.getResources().getString(R.string.Spain_s));

        if (nationality.equals(context.getResources().getString(R.string.Sri_Lankan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Sri_Lanka),context.getResources().getString(R.string.Sri_Lanka_s));

        if (nationality.equals(context.getResources().getString(R.string.Sudanese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Sudan),context.getResources().getString(R.string.Sudan_s));

        if (nationality.equals(context.getResources().getString(R.string.Swedish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Sweden),context.getResources().getString(R.string.Sweden_s));

        if (nationality.equals(context.getResources().getString(R.string.Swiss_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Switzerland),context.getResources().getString(R.string.Switzerland_s));

        if (nationality.equals(context.getResources().getString(R.string.Syrian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Syria),context.getResources().getString(R.string.Syria_s));

        if (nationality.equals(context.getResources().getString(R.string.Taiwanese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Taiwan),context.getResources().getString(R.string.Taiwan_s));

        if (nationality.equals(context.getResources().getString(R.string.Tajikistani_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Tajikistan),context.getResources().getString(R.string.Tajikistan_s));

        if (nationality.equals(context.getResources().getString(R.string.Thai_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Thailand),context.getResources().getString(R.string.Thailand_s));

        if (nationality.equals(context.getResources().getString(R.string.Tongan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Tonga),context.getResources().getString(R.string.Tonga_s));

        if (nationality.equals(context.getResources().getString(R.string.Tunisian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Tunisia),context.getResources().getString(R.string.Tunisia_s));

        if (nationality.equals(context.getResources().getString(R.string.Turkish_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Turkey),context.getResources().getString(R.string.Turkey_s));

        if (nationality.equals(context.getResources().getString(R.string.Ukrainian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Ukraine),context.getResources().getString(R.string.Ukraine_s));

        if (nationality.equals(context.getResources().getString(R.string.Emirati_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.United_Arab_Emirates),context.getResources().getString(R.string.United_Arab_Emirates_s));

        if (nationality.equals(context.getResources().getString(R.string.British_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.United_Kingdom),context.getResources().getString(R.string.United_Kingdom_s));

        if (nationality.equals(context.getResources().getString(R.string.American_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.United_States),context.getResources().getString(R.string.United_States_s));

        if (nationality.equals(context.getResources().getString(R.string.Uruguayan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Uruguay),context.getResources().getString(R.string.Uruguay_s));

        if (nationality.equals(context.getResources().getString(R.string.Venezuelan_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Venezuela),context.getResources().getString(R.string.Venezuela_s));

        if (nationality.equals(context.getResources().getString(R.string.Vietnamese_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Vietnam),context.getResources().getString(R.string.Vietnam_s));

        if (nationality.equals(context.getResources().getString(R.string.Welsh_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Wales),context.getResources().getString(R.string.Wales_s));

        if (nationality.equals(context.getResources().getString(R.string.Zambian_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Zambia),context.getResources().getString(R.string.Zambia_s));

        if (nationality.equals(context.getResources().getString(R.string.Zimbabwean_s)))
            licenseNationality = new License_Nationality(context.getResources().getString(R.string.Zimbabwe),context.getResources().getString(R.string.Zimbabwe_s));


        return licenseNationality;
    }

    public static ArrayList<Nationality> fillNationalityArrayL(Context context) {
        ArrayList<Nationality> nationalityTypesArrayL = new ArrayList<Nationality>();

        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Afghan),context.getResources().getString(R.string.Afghan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Albanian),context.getResources().getString(R.string.Albanian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Algerian),context.getResources().getString(R.string.Algerian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Argentine),context.getResources().getString(R.string.Argentine_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Australian),context.getResources().getString(R.string.Australian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Austrian),context.getResources().getString(R.string.Austrian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Bangladeshi),context.getResources().getString(R.string.Bangladeshi_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Belgian),context.getResources().getString(R.string.Belgian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Bolivian),context.getResources().getString(R.string.Bolivian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Batswana),context.getResources().getString(R.string.Batswana_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Brazilian),context.getResources().getString(R.string.Brazilian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Bulgarian),context.getResources().getString(R.string.Bulgarian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Cambodian),context.getResources().getString(R.string.Cambodian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Cameroonian),context.getResources().getString(R.string.Cameroonian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Canadian),context.getResources().getString(R.string.Canadian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Chilean),context.getResources().getString(R.string.Chilean_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Chinese),context.getResources().getString(R.string.Chinese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Colombian),context.getResources().getString(R.string.Colombian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Costa_Rican),context.getResources().getString(R.string.Costa_Rican_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Croatian),context.getResources().getString(R.string.Croatian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Cuban),context.getResources().getString(R.string.Cuban_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Czech),context.getResources().getString(R.string.Czech_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Danish),context.getResources().getString(R.string.Danish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Dominican),context.getResources().getString(R.string.Dominican_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Ecuadorian),context.getResources().getString(R.string.Ecuadorian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Egyptian),context.getResources().getString(R.string.Egyptian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Salvadorian),context.getResources().getString(R.string.Salvadorian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.English),context.getResources().getString(R.string.English_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Estonian),context.getResources().getString(R.string.Estonian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Ethiopian),context.getResources().getString(R.string.Ethiopian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Fijian),context.getResources().getString(R.string.Fijian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Finnish),context.getResources().getString(R.string.Finnish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.French),context.getResources().getString(R.string.French_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.German),context.getResources().getString(R.string.German_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Ghanaian),context.getResources().getString(R.string.Ghanaian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Greek),context.getResources().getString(R.string.Greek_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Guatemalan),context.getResources().getString(R.string.Guatemalan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Haitian),context.getResources().getString(R.string.Haitian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Honduran),context.getResources().getString(R.string.Honduran_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Hungarian),context.getResources().getString(R.string.Hungarian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Icelandic),context.getResources().getString(R.string.Icelandic_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Indian),context.getResources().getString(R.string.Indian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Indonesian),context.getResources().getString(R.string.Indonesian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Iranian),context.getResources().getString(R.string.Iranian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Iraqi),context.getResources().getString(R.string.Iraqi_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Irish),context.getResources().getString(R.string.Irish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Israeli),context.getResources().getString(R.string.Israeli_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Italian),context.getResources().getString(R.string.Italian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Jamaican),context.getResources().getString(R.string.Jamaican_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Japanese),context.getResources().getString(R.string.Japanese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Jordanian),context.getResources().getString(R.string.Jordanian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Kenyan),context.getResources().getString(R.string.Kenyan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Kuwaiti),context.getResources().getString(R.string.Kuwaiti_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Lao),context.getResources().getString(R.string.Lao_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Latvian),context.getResources().getString(R.string.Latvian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Lebanese),context.getResources().getString(R.string.Lebanese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Libyan),context.getResources().getString(R.string.Libyan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Lithuanian),context.getResources().getString(R.string.Lithuanian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Malagasy),context.getResources().getString(R.string.Malagasy_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Malaysian),context.getResources().getString(R.string.Malaysian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Malian),context.getResources().getString(R.string.Malian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Maltese),context.getResources().getString(R.string.Maltese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Mexican),context.getResources().getString(R.string.Mexican_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Mongolian),context.getResources().getString(R.string.Mongolian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Moroccan),context.getResources().getString(R.string.Moroccan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Mozambican),context.getResources().getString(R.string.Mozambican_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Namibian),context.getResources().getString(R.string.Namibian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Nepalese),context.getResources().getString(R.string.Nepalese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Dutch),context.getResources().getString(R.string.Dutch_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.New_Zealand),context.getResources().getString(R.string.New_Zealand_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Nicaraguan),context.getResources().getString(R.string.Nicaraguan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Nigerian),context.getResources().getString(R.string.Nigerian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Norwegian),context.getResources().getString(R.string.Norwegian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Pakistani),context.getResources().getString(R.string.Pakistani_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Panamanian),context.getResources().getString(R.string.Panamanian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Paraguayan),context.getResources().getString(R.string.Paraguayan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Peruvian),context.getResources().getString(R.string.Peruvian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Philippine),context.getResources().getString(R.string.Philippine_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Polish),context.getResources().getString(R.string.Polish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Portuguese),context.getResources().getString(R.string.Portuguese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Romanian),context.getResources().getString(R.string.Romanian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Russian),context.getResources().getString(R.string.Russian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Saudi),context.getResources().getString(R.string.Saudi_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Scottish),context.getResources().getString(R.string.Scottish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Senegalese),context.getResources().getString(R.string.Senegalese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Serbian),context.getResources().getString(R.string.Serbian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Singaporean),context.getResources().getString(R.string.Singaporean_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Slovak),context.getResources().getString(R.string.Slovak_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.South_African),context.getResources().getString(R.string.South_African_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Korean),context.getResources().getString(R.string.Korean_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Spanish),context.getResources().getString(R.string.Spanish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Sri_Lankan),context.getResources().getString(R.string.Sri_Lankan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Sudanese),context.getResources().getString(R.string.Sudanese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Swedish),context.getResources().getString(R.string.Swedish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Swiss),context.getResources().getString(R.string.Swiss_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Syrian),context.getResources().getString(R.string.Syrian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Taiwanese),context.getResources().getString(R.string.Taiwanese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Tajikistani),context.getResources().getString(R.string.Tajikistani_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Thai),context.getResources().getString(R.string.Thai_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Tongan),context.getResources().getString(R.string.Tongan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Tunisian),context.getResources().getString(R.string.Tunisian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Turkish),context.getResources().getString(R.string.Turkish_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Ukrainian),context.getResources().getString(R.string.Ukrainian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Emirati),context.getResources().getString(R.string.Emirati_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.British),context.getResources().getString(R.string.British_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.American),context.getResources().getString(R.string.American_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Uruguayan),context.getResources().getString(R.string.Uruguayan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Venezuelan),context.getResources().getString(R.string.Venezuelan_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Vietnamese),context.getResources().getString(R.string.Vietnamese_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Welsh),context.getResources().getString(R.string.Welsh_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Zambian),context.getResources().getString(R.string.Zambian_s)));
        nationalityTypesArrayL.add(new Nationality(context.getResources().getString(R.string.Zimbabwean),context.getResources().getString(R.string.Zimbabwean_s)));

        return nationalityTypesArrayL;
    }

    public static ArrayList<License_Nationality> fillLicenseNationalityArrayL(Context context) {
        ArrayList<License_Nationality> licenseNationalityTypesArrayL = new ArrayList<License_Nationality>();

        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Afghanistan),context.getResources().getString(R.string.Afghanistan_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Albania),context.getResources().getString(R.string.Albania_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Algeria),context.getResources().getString(R.string.Algeria_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Argentina),context.getResources().getString(R.string.Argentina_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Australia),context.getResources().getString(R.string.Australia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Austria),context.getResources().getString(R.string.Austria_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Bangladesh),context.getResources().getString(R.string.Bangladesh_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Belgium),context.getResources().getString(R.string.Belgium_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Bolivia),context.getResources().getString(R.string.Bolivia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Botswana),context.getResources().getString(R.string.Botswana_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Brazil),context.getResources().getString(R.string.Brazil_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Bulgaria),context.getResources().getString(R.string.Bulgaria_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Cambodia),context.getResources().getString(R.string.Cambodia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Cameroon),context.getResources().getString(R.string.Cameroon_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Canada),context.getResources().getString(R.string.Canada_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Chile),context.getResources().getString(R.string.Chile_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.China),context.getResources().getString(R.string.China_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Colombia),context.getResources().getString(R.string.Colombia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Costa_Rica),context.getResources().getString(R.string.Costa_Rica_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Croatia),context.getResources().getString(R.string.Croatia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Cuba),context.getResources().getString(R.string.Cuba_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Czech_Republic),context.getResources().getString(R.string.Czech_Republic_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Denmark),context.getResources().getString(R.string.Denmark_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Dominican_Republic),context.getResources().getString(R.string.Dominican_Republic_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Ecuador),context.getResources().getString(R.string.Ecuador_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Egypt),context.getResources().getString(R.string.Egypt_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.El_Salvador),context.getResources().getString(R.string.El_Salvador_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.England),context.getResources().getString(R.string.England_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Estonia),context.getResources().getString(R.string.Estonia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Ethiopia),context.getResources().getString(R.string.Ethiopia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Fiji),context.getResources().getString(R.string.Fiji_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Finland),context.getResources().getString(R.string.Finland_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.France),context.getResources().getString(R.string.France_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Germany),context.getResources().getString(R.string.Germany_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Ghana),context.getResources().getString(R.string.Ghana_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Greece),context.getResources().getString(R.string.Greece_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Guatemala),context.getResources().getString(R.string.Guatemala_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Haiti),context.getResources().getString(R.string.Haiti_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Honduras),context.getResources().getString(R.string.Honduras_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Hungary),context.getResources().getString(R.string.Hungary_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Iceland),context.getResources().getString(R.string.Iceland_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.India),context.getResources().getString(R.string.India_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Indonesia),context.getResources().getString(R.string.Indonesia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Iran),context.getResources().getString(R.string.Iran_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Iraq),context.getResources().getString(R.string.Iraq_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Ireland),context.getResources().getString(R.string.Ireland_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Israel),context.getResources().getString(R.string.Israel_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Italy),context.getResources().getString(R.string.Italy_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Jamaica),context.getResources().getString(R.string.Jamaica_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Japan),context.getResources().getString(R.string.Japan_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Jordan),context.getResources().getString(R.string.Jordan_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Kenya),context.getResources().getString(R.string.Kenya_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Kuwait),context.getResources().getString(R.string.Kuwait_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Laos),context.getResources().getString(R.string.Laos_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Latvia),context.getResources().getString(R.string.Latvia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Lebanon),context.getResources().getString(R.string.Lebanon_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Libya),context.getResources().getString(R.string.Libya_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Lithuania),context.getResources().getString(R.string.Lithuania_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Madagascar),context.getResources().getString(R.string.Madagascar_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Malaysia),context.getResources().getString(R.string.Malaysia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Mali),context.getResources().getString(R.string.Mali_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Malta),context.getResources().getString(R.string.Malta_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Mexico),context.getResources().getString(R.string.Mexico_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Mongolia),context.getResources().getString(R.string.Mongolia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Morocco),context.getResources().getString(R.string.Morocco_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Mozambique),context.getResources().getString(R.string.Mozambique_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Namibia),context.getResources().getString(R.string.Namibia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Nepal),context.getResources().getString(R.string.Nepal_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Netherlands),context.getResources().getString(R.string.Netherlands_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.New_Zealand_c),context.getResources().getString(R.string.New_Zealand_c_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Nicaragua),context.getResources().getString(R.string.Nicaragua_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Nigeria),context.getResources().getString(R.string.Nigeria_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Norway),context.getResources().getString(R.string.Norway_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Pakistan),context.getResources().getString(R.string.Pakistan_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Panama),context.getResources().getString(R.string.Panama_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Paraguay),context.getResources().getString(R.string.Paraguay_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Peru),context.getResources().getString(R.string.Peru_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Philippines),context.getResources().getString(R.string.Philippines_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Poland),context.getResources().getString(R.string.Poland_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Portugal),context.getResources().getString(R.string.Portugal_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Romania),context.getResources().getString(R.string.Romania_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Russia),context.getResources().getString(R.string.Russia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Saudi_Arabia),context.getResources().getString(R.string.Saudi_Arabia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Scotland),context.getResources().getString(R.string.Scotland_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Senegal),context.getResources().getString(R.string.Senegal_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Serbia),context.getResources().getString(R.string.Serbia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Singapore),context.getResources().getString(R.string.Singapore_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Slovakia),context.getResources().getString(R.string.Slovakia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.South_Africa),context.getResources().getString(R.string.South_Africa_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.South_Korea),context.getResources().getString(R.string.South_Korea_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Spain),context.getResources().getString(R.string.Spain_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Sri_Lanka),context.getResources().getString(R.string.Sri_Lanka_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Sudan),context.getResources().getString(R.string.Sudan_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Sweden),context.getResources().getString(R.string.Sweden_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Switzerland),context.getResources().getString(R.string.Switzerland_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Syria),context.getResources().getString(R.string.Syria_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Taiwan),context.getResources().getString(R.string.Taiwan_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Tajikistan),context.getResources().getString(R.string.Tajikistan_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Thailand),context.getResources().getString(R.string.Thailand_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Tonga),context.getResources().getString(R.string.Tonga_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Tunisia),context.getResources().getString(R.string.Tunisia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Turkey),context.getResources().getString(R.string.Turkey_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Ukraine),context.getResources().getString(R.string.Ukraine_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.United_Arab_Emirates),context.getResources().getString(R.string.United_Arab_Emirates_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.United_Kingdom),context.getResources().getString(R.string.United_Kingdom_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.United_States),context.getResources().getString(R.string.United_States_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Uruguay),context.getResources().getString(R.string.Uruguay_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Venezuela),context.getResources().getString(R.string.Venezuela_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Vietnam),context.getResources().getString(R.string.Vietnam_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Wales),context.getResources().getString(R.string.Wales_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Zambia),context.getResources().getString(R.string.Zambia_s)));
        licenseNationalityTypesArrayL.add(new License_Nationality(context.getResources().getString(R.string.Zimbabwe),context.getResources().getString(R.string.Zimbabwe_s)));

        return licenseNationalityTypesArrayL;
    }

    public static ArrayList<LicenseDuration> fillLicenseDurationArrayL(Context context) {
        ArrayList<LicenseDuration> licenseDurationArrayL = new ArrayList<LicenseDuration>();

        licenseDurationArrayL.add(new LicenseDuration(context.getResources().getString(R.string.drive_duration_content1),context.getResources().getString(R.string.drive_duration_content1_s)));
        licenseDurationArrayL.add(new LicenseDuration(context.getResources().getString(R.string.drive_duration_content2),context.getResources().getString(R.string.drive_duration_content2_s)));
        licenseDurationArrayL.add(new LicenseDuration(context.getResources().getString(R.string.drive_duration_content3),context.getResources().getString(R.string.drive_duration_content3_s)));
        licenseDurationArrayL.add(new LicenseDuration(context.getResources().getString(R.string.drive_duration_content4),context.getResources().getString(R.string.drive_duration_content4_s)));
        licenseDurationArrayL.add(new LicenseDuration(context.getResources().getString(R.string.drive_duration_content5),context.getResources().getString(R.string.drive_duration_content5_s)));
        licenseDurationArrayL.add(new LicenseDuration(context.getResources().getString(R.string.drive_duration_content6),context.getResources().getString(R.string.drive_duration_content6_s)));
        licenseDurationArrayL.add(new LicenseDuration(context.getResources().getString(R.string.drive_duration_content7),context.getResources().getString(R.string.drive_duration_content7_s)));

        return licenseDurationArrayL;
    }

    public static ArrayList<DriverProcess> fillDriverProcessArrayL(Context context) {
        ArrayList<DriverProcess> driverProcessArrayL = new ArrayList<DriverProcess>();

        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.birth_day_process),context.getResources().getString(R.string.birth_day_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.email_process),context.getResources().getString(R.string.email_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.phone_number_process),context.getResources().getString(R.string.phone_number_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.name_process),context.getResources().getString(R.string.name_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.certificate_claims_process),context.getResources().getString(R.string.certificate_claims_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.insurance_pay_process),context.getResources().getString(R.string.insurance_pay_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.register_date_process),context.getResources().getString(R.string.register_date_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.drive_duration_process),context.getResources().getString(R.string.drive_duration_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.lic_nationality_process),context.getResources().getString(R.string.lic_nationality_process_s)));
        driverProcessArrayL.add(new DriverProcess(context.getResources().getString(R.string.nationality_process),context.getResources().getString(R.string.nationality_process_s)));

        return driverProcessArrayL;
    }

    public static ArrayList<CarProcess> fillCarProcessArrayL(Context context) {
        ArrayList<CarProcess> carProcessArrayL = new ArrayList<CarProcess>();

        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.agency_repair_process),context.getResources().getString(R.string.agency_repair_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.insurance_policy_process),context.getResources().getString(R.string.insurance_policy_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.car_modified_process),context.getResources().getString(R.string.car_modified_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.licence_expired_process),context.getResources().getString(R.string.licence_expired_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.car_city_process),context.getResources().getString(R.string.car_city_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.car_cylinder_process),context.getResources().getString(R.string.car_cylinder_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.car_condition_process),context.getResources().getString(R.string.car_condition_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.car_year_process),context.getResources().getString(R.string.car_year_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.car_model_process),context.getResources().getString(R.string.car_model_process_s)));
        carProcessArrayL.add(new CarProcess(context.getResources().getString(R.string.car_make_process),context.getResources().getString(R.string.car_make_process_s)));

        return carProcessArrayL;
    }

    public static ArrayList<CylinderNumber> fillCylinderNumberArrayL(Context context) {
        ArrayList<CylinderNumber> cylinderNumbersArrayL = new ArrayList<CylinderNumber>();

        cylinderNumbersArrayL.add(new CylinderNumber(context.getResources().getString(R.string.car_cylinder_1),context.getResources().getString(R.string.car_cylinder_1_s)));
        cylinderNumbersArrayL.add(new CylinderNumber(context.getResources().getString(R.string.car_cylinder_2),context.getResources().getString(R.string.car_cylinder_2_s)));
        cylinderNumbersArrayL.add(new CylinderNumber(context.getResources().getString(R.string.car_cylinder_3),context.getResources().getString(R.string.car_cylinder_3_s)));
        cylinderNumbersArrayL.add(new CylinderNumber(context.getResources().getString(R.string.car_cylinder_4),context.getResources().getString(R.string.car_cylinder_4_s)));
        cylinderNumbersArrayL.add(new CylinderNumber(context.getResources().getString(R.string.car_cylinder_5),context.getResources().getString(R.string.car_cylinder_5_s)));

        return cylinderNumbersArrayL;
    }

    public static ArrayList<CityModel> fillCitiesArrayL(Context context) {
        ArrayList<CityModel> citiesArrayL = new ArrayList<CityModel>();

        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_ar)));
        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_ar)));
        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_ar)));
        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_ar)));
        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_ar)));
        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_ar)));
        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_ar)));
        citiesArrayL.add(new CityModel(context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_ar)));

        return citiesArrayL;
    }

    public static void createDriverInfoTable(Context context){
        ArrayList<DriverProcess> driverProcessArrayL = new ArrayList<DriverProcess>();
        driverProcessArrayL = fillDriverProcessArrayL(context);
        DBHelper database=getDataBaseInstance(context);
        if (checkIfDriverProcessCreated(context) ==0)
        {
            for (int i=0;i<driverProcessArrayL.size();i++)
            {
                ProcessContent processContent = new ProcessContent(context.getResources().getString(R.string.empty),"empty");
                DriverInformation driverInformation = new DriverInformation(driverProcessArrayL.get(i),processContent,false);
                //insertDriverProcessTable(driverInformation,database);
            }
        }
    }

    public static void createCarInfoTable(Context context){
        ArrayList<CarProcess> carProcessArrayL = new ArrayList<CarProcess>();
        carProcessArrayL = fillCarProcessArrayL(context);
        DBHelper database=getDataBaseInstance(context);
        if (checkIfCarDetailsProcessCreated(context) ==0)
        {
            for (int i=0;i<carProcessArrayL.size();i++)
            {
                ProcessContent processContent = new ProcessContent(context.getResources().getString(R.string.empty),"empty");
                CarInformation carInformation = new CarInformation(carProcessArrayL.get(i),processContent,false);
                //insertCarProcessTable(carInformation,database);
            }
        }
    }

    public static int numberOfDriverProcessSelected(Context context){
        int numberOfCompletedProcess =0;
        ArrayList<DriverInformation> driverAllProcessArrayL = new ArrayList<DriverInformation>();
        driverAllProcessArrayL = getAllDriverProcess(context);

        if (checkIfDriverProcessCreated(context) !=0)
        {
            for (int i=0;i<driverAllProcessArrayL.size();i++)
            {
                if (driverAllProcessArrayL.get(i).isProcessStatus())
                    numberOfCompletedProcess = numberOfCompletedProcess+1;
            }
        }
        return numberOfCompletedProcess;
    }

    public static int numberOfCarProcessSelected(Context context){
        int numberOfCompletedProcess =0;
        ArrayList<CarInformation> carAllProcessArrayL = new ArrayList<CarInformation>();
        //carAllProcessArrayL = getAllCarProcess(context);

        if (checkIfCarDetailsProcessCreated(context) !=0)
        {
            for (int i=0;i<carAllProcessArrayL.size();i++)
            {
                if (carAllProcessArrayL.get(i).isProcessStatus())
                    numberOfCompletedProcess = numberOfCompletedProcess+1;
            }
        }
        return numberOfCompletedProcess;
    }

    public static String nextFragment(int numberOfCompleteFragments){
        String nextFragment = null;

        switch (numberOfCompleteFragments) {
            case 0:
                nextFragment = "Nationality";
                break;
            case 1:
                nextFragment = "License Nationality";
                break;
            case 2:
                nextFragment = "Drive duration";
                break;
            case 3:
                nextFragment = "Register Date";
                break;
            case 4:
                nextFragment = "Insurance pay";
                break;
            case 5:
                nextFragment = "Certificate claims";
                break;
            case 6:
                nextFragment = "Name";
                break;
            case 7:
                nextFragment = "Phone number";
                break;
            case 8:
                nextFragment = "Email";
                break;
            case 9:
                nextFragment = "Birth day";
                break;
        }

        return nextFragment;
    }

    public static String nextCarFragment(int numberOfCompleteFragments){
        String nextFragment = null;

        switch (numberOfCompleteFragments) {
            case 0:
                nextFragment = "Car make";
                break;
            case 1:
                nextFragment = "Car model";
                break;
            case 2:
                nextFragment = "Car year";
                break;
            case 3:
                nextFragment = "Car condition";
                break;
            case 4:
                nextFragment = "Car cylinder";
                break;
            case 5:
                nextFragment = "City";
                break;
            case 6:
                nextFragment = "Licence expired";
                break;
            case 7:
                nextFragment = "Modified";
                break;
            case 8:
                nextFragment = "Insurance policy";
                break;
            case 9:
                nextFragment = "Agency repair";
                break;
        }

        return nextFragment;
    }

    public static String processName(int numberOfCompleteFragments,Context context){
        String processName = null;

        switch (numberOfCompleteFragments) {
            case 0:
                processName = context.getResources().getString(R.string.nationality);
                break;
            case 1:
                processName = context.getResources().getString(R.string.lic_nationality_process);
                break;
            case 2:
                processName = context.getResources().getString(R.string.drive_duration_process);
                break;
            case 3:
                processName = context.getResources().getString(R.string.register_date_process);
                break;
            case 4:
                processName = context.getResources().getString(R.string.insurance_pay_process);
                break;
            case 5:
                processName = context.getResources().getString(R.string.certificate_claims_process);
                break;
            case 6:
                processName = context.getResources().getString(R.string.name_process);
                break;
            case 7:
                processName = context.getResources().getString(R.string.phone_number_process);
                break;
            case 8:
                processName = context.getResources().getString(R.string.email_process);
                break;
            case 9:
                processName = context.getResources().getString(R.string.birth_day_process);
                break;
        }
        return processName;
    }

    public static String processCarName(int numberOfCompleteFragments,Context context){
        String processName = null;

        switch (numberOfCompleteFragments) {
            case 0:
                processName = context.getResources().getString(R.string.car_make_process);
                break;
            case 1:
                processName = context.getResources().getString(R.string.car_model_process);
                break;
            case 2:
                processName = context.getResources().getString(R.string.car_year_process);
                break;
            case 3:
                processName = context.getResources().getString(R.string.car_condition_process);
                break;
            case 4:
                processName = context.getResources().getString(R.string.car_cylinder_process);
                break;
            case 5:
                processName = context.getResources().getString(R.string.car_city_process);
                break;
            case 6:
                processName = context.getResources().getString(R.string.licence_expired);
                break;
            case 7:
                processName = context.getResources().getString(R.string.car_modified_process);
                break;
            case 8:
                processName = context.getResources().getString(R.string.insurance_policy_process);
                break;
            case 9:
                processName = context.getResources().getString(R.string.agency_repair_process);
                break;
        }
        return processName;
    }

    public static DriverInformation getDriverProcess(Context context,String processTypeS){
        Cursor res = getDataBaseInstance(context).getDriverInfo(processTypeS);

        DriverProcess driverProcess= new DriverProcess(
                res.getString(2).replace("\n", "")
                ,res.getString(1).replace("\n", "")
        );
        ProcessContent processContent=new ProcessContent(
                res.getString(3).replace("\n", "")
                ,res.getString(4).replace("\n", "")
        );
        boolean isSelected = Boolean.valueOf(res.getString(5).replace("\n", ""));

        DriverInformation driverInformation = new DriverInformation(
                driverProcess,processContent,isSelected
        );

        return driverInformation;
    }

//    public static CarInformation getCarProcess(Context context,String processTypeS){
//        Cursor res = getDataBaseInstance(context).getCarDetails(processTypeS);
//
//        CarProcess driverProcess= new CarProcess(
//                res.getString(2).replace("\n", "")
//                ,res.getString(1).replace("\n", "")
//        );
//        ProcessContent processContent=new ProcessContent(
//                res.getString(3).replace("\n", "")
//                ,res.getString(4).replace("\n", "")
//        );
//        boolean isSelected = Boolean.valueOf(res.getString(5).replace("\n", ""));
//
//        CarInformation carInformation = new CarInformation(
//                driverProcess,processContent,isSelected
//        );
//
//        return carInformation;
//    }

    public static void resetAllDriverInfoTable(Context context){
        DBHelper database=getDataBaseInstance(context);
        database.deleteAllDriverInfo();

        createDriverInfoTable(context);
    }

    public static void resetAllCarInfoTable(Context context){
        DBHelper database=getDataBaseInstance(context);
        database.deleteAllCarDetails();

        createCarInfoTable(context);
    }

    public static ArrayList<CertificateClaims> fillCertificateClaimsArrayL(Context context) {
        ArrayList<CertificateClaims> certificateClaimsArrayL = new ArrayList<CertificateClaims>();

        certificateClaimsArrayL.add(new CertificateClaims(context.getResources().getString(R.string.certificate_claims_1),context.getResources().getString(R.string.certificate_claims_1_s)));
        certificateClaimsArrayL.add(new CertificateClaims(context.getResources().getString(R.string.certificate_claims_2),context.getResources().getString(R.string.certificate_claims_2_s)));
        certificateClaimsArrayL.add(new CertificateClaims(context.getResources().getString(R.string.certificate_claims_3),context.getResources().getString(R.string.certificate_claims_3_s)));
        certificateClaimsArrayL.add(new CertificateClaims(context.getResources().getString(R.string.certificate_claims_4),context.getResources().getString(R.string.certificate_claims_4_s)));
        certificateClaimsArrayL.add(new CertificateClaims(context.getResources().getString(R.string.certificate_claims_5),context.getResources().getString(R.string.certificate_claims_5_s)));

        return certificateClaimsArrayL;
    }
}
