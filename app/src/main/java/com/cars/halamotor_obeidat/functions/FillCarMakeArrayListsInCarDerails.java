package com.cars.halamotor_obeidat.functions;

import android.content.Context;

import com.cars.halamotor_obeidat.model.CarMake;
import com.cars.halamotor_obeidat.model.ItemFilterModel;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.ReadCarsAndCarModels.getBrands;
import static com.cars.halamotor_obeidat.functions.FillText.getTextEngOrLocal;

public class FillCarMakeArrayListsInCarDerails {

//    public static ArrayList<CarMake> fillCarMakeArrayL(ArrayList<CarMake> carMakeArrayList, Context context) {
//        carMakeArrayList = new ArrayList<CarMake>();
//
//
//
//        CarMake carMake1 = new CarMake(R.drawable.hyundai,context.getResources().getString(R.string.hyundai),context.getResources().getString(R.string.hyundai_s),context.getResources().getString(R.string.hyundai_ar));
//        CarMake carMake2 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.toyota),context.getResources().getString(R.string.toyota_s),context.getResources().getString(R.string.toyota_ar));
//        CarMake carMake3 = new CarMake(R.drawable.kia,context.getResources().getString(R.string.kia),context.getResources().getString(R.string.kia_s),context.getResources().getString(R.string.kia_ar));
//        CarMake carMake4 = new CarMake(R.drawable.bmw,context.getResources().getString(R.string.bmw),context.getResources().getString(R.string.bmw_s),context.getResources().getString(R.string.bmw_ar));
//        CarMake carMake5 = new CarMake(R.drawable.mercedes_benz,context.getResources().getString(R.string.mercedes_benz),context.getResources().getString(R.string.mercedes_benz_s),context.getResources().getString(R.string.mercedes_benz_ar));
//        CarMake carMake6 = new CarMake(R.drawable.aston_martin,context.getResources().getString(R.string.aston_martin),context.getResources().getString(R.string.aston_martin_s),context.getResources().getString(R.string.aston_martin_ar));
//        CarMake carMake7 = new CarMake(R.drawable.alfa_romeo,context.getResources().getString(R.string.alfa_romeo),context.getResources().getString(R.string.alfa_romeo_s),context.getResources().getString(R.string.alfa_romeo_ar));
//        CarMake carMake8 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.audi),context.getResources().getString(R.string.audi_s),context.getResources().getString(R.string.audi_ar));
//        CarMake carMake9 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.isuzu),context.getResources().getString(R.string.isuzu_s),context.getResources().getString(R.string.isuzu_ar));
//
//        CarMake carMake10 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.infiniti),context.getResources().getString(R.string.infiniti_s),context.getResources().getString(R.string.infiniti_ar));
//        CarMake carMake11= new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.opel),context.getResources().getString(R.string.opel_s),context.getResources().getString(R.string.opel_ar));
//        CarMake carMake12 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.bentley),context.getResources().getString(R.string.bentley_s),context.getResources().getString(R.string.bentley_ar));
//        CarMake carMake13 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.porsche),context.getResources().getString(R.string.porsche_s),context.getResources().getString(R.string.porsche_ar));
//        CarMake carMake14 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.pontiac),context.getResources().getString(R.string.pontiac_s),context.getResources().getString(R.string.pontiac_ar));
//        CarMake carMake16 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.peugeot),context.getResources().getString(R.string.peugeot_s),context.getResources().getString(R.string.peugeot_ar));
//        CarMake carMake17 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.jaguar),context.getResources().getString(R.string.jaguar_s),context.getResources().getString(R.string.jaguar_ar));
//        CarMake carMake18 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.great_wall),context.getResources().getString(R.string.great_wall_s),context.getResources().getString(R.string.great_wall_ar));
//        CarMake carMake19 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.gmc),context.getResources().getString(R.string.gmc_s),context.getResources().getString(R.string.gmc_ar));
//        CarMake carMake20 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.jeep),context.getResources().getString(R.string.jeep_s),context.getResources().getString(R.string.jeep_ar));
//
//        CarMake carMake21 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.daihatsu),context.getResources().getString(R.string.daihatsu_s),context.getResources().getString(R.string.daihatsu_ar));
//        CarMake carMake22 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.daewoo),context.getResources().getString(R.string.daewoo_s),context.getResources().getString(R.string.daewoo_ar));
//        CarMake carMake23 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.dodge),context.getResources().getString(R.string.dodge_s),context.getResources().getString(R.string.dodge_ar));
//        CarMake carMake24 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.rover),context.getResources().getString(R.string.rover_s),context.getResources().getString(R.string.rover_ar));
//        CarMake carMake25 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.rolls_royce),context.getResources().getString(R.string.rolls_royce_s),context.getResources().getString(R.string.rolls_royce_ar));
//        CarMake carMake26 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.renault),context.getResources().getString(R.string.renault_s),context.getResources().getString(R.string.renault_ar));
//        CarMake carMake27 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.saab),context.getResources().getString(R.string.saab_s),context.getResources().getString(R.string.saab_ar));
//        CarMake carMake28 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.saturn),context.getResources().getString(R.string.saturn_s),context.getResources().getString(R.string.saturn_ar));
//        CarMake carMake29 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.ssang_yong),context.getResources().getString(R.string.ssang_yong_s),context.getResources().getString(R.string.ssang_yong_ar));
//        CarMake carMake30 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.citroen),context.getResources().getString(R.string.citroen_s),context.getResources().getString(R.string.citroen_ar));
//
//        CarMake carMake31 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.skoda),context.getResources().getString(R.string.skoda_s),context.getResources().getString(R.string.skoda_ar));
//        CarMake carMake32 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.subaru),context.getResources().getString(R.string.subaru_s),context.getResources().getString(R.string.subaru_ar));
//        CarMake carMake33 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.suzuki),context.getResources().getString(R.string.suzuki_s),context.getResources().getString(R.string.suzuki_ar));
//        CarMake carMake34 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.seat),context.getResources().getString(R.string.seat_s),context.getResources().getString(R.string.seat_ar));
//        CarMake carMake35 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.chery),context.getResources().getString(R.string.chery_s),context.getResources().getString(R.string.chery_ar));
//        CarMake carMake36 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.chevrolat),context.getResources().getString(R.string.chevrolat_s),context.getResources().getString(R.string.chevrolat_ar));
//        CarMake carMake37 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.ford),context.getResources().getString(R.string.ford_s),context.getResources().getString(R.string.ford_ar));
//        CarMake carMake38 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.volvo),context.getResources().getString(R.string.volvo_s),context.getResources().getString(R.string.volvo_ar));
//        CarMake carMake39 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.volkswagen),context.getResources().getString(R.string.volkswagen_s),context.getResources().getString(R.string.volkswagen_ar));
//        CarMake carMake40 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.fiat),context.getResources().getString(R.string.fiat_s),context.getResources().getString(R.string.fiat_ar));
//
//        CarMake carMake41 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.ferrari),context.getResources().getString(R.string.ferrari_s),context.getResources().getString(R.string.ferrari_ar));
//        CarMake carMake42 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.cadillac),context.getResources().getString(R.string.cadillac_s),context.getResources().getString(R.string.cadillac_ar));
//        CarMake carMake43 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.chrysler),context.getResources().getString(R.string.chrysler_s),context.getResources().getString(R.string.chrysler_ar));
//        CarMake carMake44 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.lada),context.getResources().getString(R.string.lada_s),context.getResources().getString(R.string.lada_ar));
//        CarMake carMake45 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.lamborghini),context.getResources().getString(R.string.lamborghini_s),context.getResources().getString(R.string.lamborghini_ar));
//        CarMake carMake46 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.land_rover),context.getResources().getString(R.string.land_rover_s),context.getResources().getString(R.string.land_rover_ar));
//        CarMake carMake47 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.lexus),context.getResources().getString(R.string.lexus_s),context.getResources().getString(R.string.lexus_ar));
//        CarMake carMake48 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.lotus),context.getResources().getString(R.string.lotus_s),context.getResources().getString(R.string.lotus_ar));
//        CarMake carMake49 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.lincoln),context.getResources().getString(R.string.lincoln_s),context.getResources().getString(R.string.lincoln_ar));
//        CarMake carMake50 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.mazda),context.getResources().getString(R.string.mazda_s),context.getResources().getString(R.string.mazda_ar));
//
//        CarMake carMake51 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.maserati),context.getResources().getString(R.string.maserati_s),context.getResources().getString(R.string.maserati_ar));
//        CarMake carMake52 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.morgan),context.getResources().getString(R.string.morgan_s),context.getResources().getString(R.string.morgan_ar));
//        CarMake carMake53 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.mitsubishi),context.getResources().getString(R.string.mitsubishi_s),context.getResources().getString(R.string.mitsubishi_ar));
//        CarMake carMake54 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.mercury),context.getResources().getString(R.string.mercury_s),context.getResources().getString(R.string.mercury_ar));
//        CarMake carMake55 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.mini),context.getResources().getString(R.string.mini_s),context.getResources().getString(R.string.mini_ar));
//        CarMake carMake56 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.nissan),context.getResources().getString(R.string.nissan_s),context.getResources().getString(R.string.nissan_ar));
//        CarMake carMake57 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.hummer),context.getResources().getString(R.string.hummer_s),context.getResources().getString(R.string.hummer_ar));
//        CarMake carMake58 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.honda),context.getResources().getString(R.string.honda_s),context.getResources().getString(R.string.honda_ar));
//        CarMake carMake59 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.geely),context.getResources().getString(R.string.geely_s),context.getResources().getString(R.string.geely_ar));
//        CarMake carMake60 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.zxauto),context.getResources().getString(R.string.zxauto_s),context.getResources().getString(R.string.zxauto_ar));
//
//        CarMake carMake61 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.mg),context.getResources().getString(R.string.mg_s),context.getResources().getString(R.string.mg_ar));
//        CarMake carMake62 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.proton),context.getResources().getString(R.string.proton_s),context.getResources().getString(R.string.proton_ar));
//        CarMake carMake63 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.brilliance),context.getResources().getString(R.string.brilliance_s),context.getResources().getString(R.string.brilliance_ar));
//        CarMake carMake64 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.byd),context.getResources().getString(R.string.byd_s),context.getResources().getString(R.string.byd_ar));
//        CarMake carMake65 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.samsung),context.getResources().getString(R.string.samsung_s),context.getResources().getString(R.string.samsung_ar));
//        CarMake carMake66 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.tesla),context.getResources().getString(R.string.tesla_s),context.getResources().getString(R.string.tesla_ar));
//        CarMake carMake67 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.iran_khodro),context.getResources().getString(R.string.iran_khodro_s),context.getResources().getString(R.string.iran_khodro_ar));
//        CarMake carMake68 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.tata),context.getResources().getString(R.string.tata_s),context.getResources().getString(R.string.tata_ar));
//        CarMake carMake69 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.bugatti),context.getResources().getString(R.string.bugatti_s),context.getResources().getString(R.string.bugatti_ar));
//        CarMake carMake70 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.buick),context.getResources().getString(R.string.buick_s),context.getResources().getString(R.string.buick_ar));
//
//        CarMake carMake71 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.acura),context.getResources().getString(R.string.acura_s),context.getResources().getString(R.string.acura_ar));
//        CarMake carMake72 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.scion),context.getResources().getString(R.string.scion_s),context.getResources().getString(R.string.scion_ar));
//        CarMake carMake73 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.mclaren),context.getResources().getString(R.string.mclaren_s),context.getResources().getString(R.string.mclaren_ar));
//        CarMake carMake74 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.pagani),context.getResources().getString(R.string.pagani_s),context.getResources().getString(R.string.pagani_ar));
//        CarMake carMake75 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.lancia),context.getResources().getString(R.string.lancia_s),context.getResources().getString(R.string.lancia_ar));
//        CarMake carMake76 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.jac),context.getResources().getString(R.string.jac_s),context.getResources().getString(R.string.jac_ar));
//        CarMake carMake77 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.lifan),context.getResources().getString(R.string.lifan_s),context.getResources().getString(R.string.lifan_ar));
//        CarMake carMake78 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.faw),context.getResources().getString(R.string.faw_s),context.getResources().getString(R.string.faw_ar));
//        CarMake carMake79 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.foton),context.getResources().getString(R.string.foton_s),context.getResources().getString(R.string.foton_ar));
//        CarMake carMake80 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.maruti_suzuki),context.getResources().getString(R.string.maruti_suzuki_s),context.getResources().getString(R.string.maruti_suzuki_ar));
//
//        CarMake carMake81 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.saipa),context.getResources().getString(R.string.saipa_s),context.getResources().getString(R.string.saipa_ar));
//        CarMake carMake82 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.private_type),context.getResources().getString(R.string.private_type_s),context.getResources().getString(R.string.private_type_ar));
//        CarMake carMake83 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.baic),context.getResources().getString(R.string.baic_s),context.getResources().getString(R.string.baic_ar));
//        CarMake carMake84 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.changan),context.getResources().getString(R.string.changan_s),context.getResources().getString(R.string.changan_ar));
//        CarMake carMake85 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.hunaghai),context.getResources().getString(R.string.hunaghai_s),context.getResources().getString(R.string.hunaghai_ar));
//        CarMake carMake86 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.dfm),context.getResources().getString(R.string.dfm_s),context.getResources().getString(R.string.dfm_ar));
//        CarMake carMake87 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.borgward),context.getResources().getString(R.string.borgward_s),context.getResources().getString(R.string.borgward_ar));
//        CarMake carMake88 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.iveco),context.getResources().getString(R.string.iveco_s),context.getResources().getString(R.string.iveco_ar));
//        CarMake carMake89 = new CarMake(R.drawable.car_for_sale,context.getResources().getString(R.string.haval),context.getResources().getString(R.string.haval_s),context.getResources().getString(R.string.haval_s));
//
//        carMakeArrayList.add(carMake1);
//        carMakeArrayList.add(carMake2);
//        carMakeArrayList.add(carMake3);
//        carMakeArrayList.add(carMake4);
//        carMakeArrayList.add(carMake5);
//        carMakeArrayList.add(carMake6);
//        carMakeArrayList.add(carMake7);
//        carMakeArrayList.add(carMake8);
//        carMakeArrayList.add(carMake9);
//        carMakeArrayList.add(carMake10);
//
//        carMakeArrayList.add(carMake11);
//        carMakeArrayList.add(carMake12);
//        carMakeArrayList.add(carMake13);
//        carMakeArrayList.add(carMake14);
//        carMakeArrayList.add(carMake16);
//        carMakeArrayList.add(carMake17);
//        carMakeArrayList.add(carMake18);
//        carMakeArrayList.add(carMake19);
//        carMakeArrayList.add(carMake20);
//        carMakeArrayList.add(carMake21);
//
//        carMakeArrayList.add(carMake22);
//        carMakeArrayList.add(carMake23);
//        carMakeArrayList.add(carMake24);
//        carMakeArrayList.add(carMake25);
//        carMakeArrayList.add(carMake26);
//        carMakeArrayList.add(carMake27);
//        carMakeArrayList.add(carMake28);
//        carMakeArrayList.add(carMake29);
//        carMakeArrayList.add(carMake30);
//        carMakeArrayList.add(carMake31);
//
//        carMakeArrayList.add(carMake32);
//        carMakeArrayList.add(carMake33);
//        carMakeArrayList.add(carMake34);
//        carMakeArrayList.add(carMake35);
//        carMakeArrayList.add(carMake36);
//        carMakeArrayList.add(carMake37);
//        carMakeArrayList.add(carMake38);
//        carMakeArrayList.add(carMake39);
//        carMakeArrayList.add(carMake40);
//        carMakeArrayList.add(carMake41);
//
//        carMakeArrayList.add(carMake42);
//        carMakeArrayList.add(carMake43);
//        carMakeArrayList.add(carMake44);
//        carMakeArrayList.add(carMake45);
//        carMakeArrayList.add(carMake46);
//        carMakeArrayList.add(carMake47);
//        carMakeArrayList.add(carMake48);
//        carMakeArrayList.add(carMake49);
//        carMakeArrayList.add(carMake50);
//        carMakeArrayList.add(carMake51);
//
//        carMakeArrayList.add(carMake52);
//        carMakeArrayList.add(carMake53);
//        carMakeArrayList.add(carMake54);
//        carMakeArrayList.add(carMake55);
//        carMakeArrayList.add(carMake56);
//        carMakeArrayList.add(carMake57);
//        carMakeArrayList.add(carMake58);
//        carMakeArrayList.add(carMake59);
//        carMakeArrayList.add(carMake60);
//        carMakeArrayList.add(carMake61);
//
//        carMakeArrayList.add(carMake62);
//        carMakeArrayList.add(carMake63);
//        carMakeArrayList.add(carMake64);
//        carMakeArrayList.add(carMake65);
//        carMakeArrayList.add(carMake66);
//        carMakeArrayList.add(carMake67);
//        carMakeArrayList.add(carMake68);
//        carMakeArrayList.add(carMake69);
//        carMakeArrayList.add(carMake70);
//        carMakeArrayList.add(carMake71);
//
//        carMakeArrayList.add(carMake72);
//        carMakeArrayList.add(carMake73);
//        carMakeArrayList.add(carMake74);
//        carMakeArrayList.add(carMake75);
//        carMakeArrayList.add(carMake76);
//        carMakeArrayList.add(carMake77);
//        carMakeArrayList.add(carMake78);
//        carMakeArrayList.add(carMake79);
//        carMakeArrayList.add(carMake80);
//        carMakeArrayList.add(carMake81);
//
//        carMakeArrayList.add(carMake82);
//        carMakeArrayList.add(carMake83);
//        carMakeArrayList.add(carMake84);
//        carMakeArrayList.add(carMake85);
//        carMakeArrayList.add(carMake86);
//        carMakeArrayList.add(carMake87);
//        carMakeArrayList.add(carMake88);
//        carMakeArrayList.add(carMake89);
//
//        return carMakeArrayList;
//    }

    public static ArrayList<ItemFilterModel> fillCarMakeArrayL(Context context) {
        ArrayList<ItemFilterModel>carMakeFilterArrayList = new ArrayList<ItemFilterModel>();

        ArrayList<CarMake>carMakeArrayList = new ArrayList<CarMake>();
        carMakeArrayList = getBrands(context);

        for (int i = 0;i<carMakeArrayList.size();i++)
        {
            String name=getTextEngOrLocal(context,carMakeArrayList.get(i).getName_en(),carMakeArrayList.get(i).getName_ar());
            ItemFilterModel itemFilterModel = new ItemFilterModel(
                    name
                    ,carMakeArrayList.get(i).getId()
            );
            carMakeFilterArrayList.add(itemFilterModel);
        }
        return carMakeFilterArrayList;
    }

}
