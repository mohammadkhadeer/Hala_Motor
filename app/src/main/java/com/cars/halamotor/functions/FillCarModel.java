package com.cars.halamotor.functions;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor.R;
import com.cars.halamotor.model.CarMake;
import com.cars.halamotor.model.CarMakeAndCarModel;
import com.cars.halamotor.model.CarModel;
import com.cars.halamotor.model.ItemFilterModel;
import com.cars.halamotor.model.SearchCar;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.ReadCarsAndCarModels.getBrands;

import static com.cars.halamotor.dataBase.ReadCarsAndCarModels.getModelsToSpecificBrand;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;


public class FillCarModel {

//    public static ArrayList<CarModel> fillCarModelArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context, String carMake) {
//        carModelArrayList = new ArrayList<CarModel>();
//
//        if (carMake.equals(context.getString(R.string.hyundai)))
//        {
//            carModelArrayList =fillCarHyundaiArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.toyota)))
//        {
//            carModelArrayList =fillCarToyotaArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.kia)))
//        {
//            carModelArrayList = fillCarKiaArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.bmw)))
//        {
//            carModelArrayList =fillCarBMWArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.mercedes_benz)))
//        {
//            carModelArrayList =fillCarMercedes_benzArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.audi)))
//        {
//            carModelArrayList =fillCarAudiArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.isuzu)))
//        {
//            carModelArrayList =fillCariSuzuArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.infiniti)))
//        {
//            carModelArrayList =fillCarInfinitiArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.opel)))
//        {
//            carModelArrayList =fillCarOpelArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.bentley)))
//        {
//            carModelArrayList =fillCarBentleyArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.porsche)))
//        {
//            carModelArrayList =fillCarPorscheArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.pontiac)))
//        {
//            carModelArrayList =fillCarPontiacArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.aston_martin)))
//        {
//            carModelArrayList =fillCarAston_martinArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.alfa_romeo)))
//        {
//            carModelArrayList =fillCarAlfa_romeoArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.pontiac)))
//        {
//            carModelArrayList =fillCarPontiacArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.peugeot)))
//        {
//            carModelArrayList =fillCarPeugeotArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.jaguar)))
//        {
//            carModelArrayList =fillCarJaguarArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.great_wall)))
//        {
//            carModelArrayList =fillCarGreat_wallArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.gmc)))
//        {
//            carModelArrayList =fillCarGMCArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.jeep)))
//        {
//            carModelArrayList =fillCarJeepArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.daihatsu)))
//        {
//            carModelArrayList =fillCarDaihatsuArrayL(carModelArrayList,context);
//        }
//        if (carMake.equals(context.getString(R.string.daewoo)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_g2x),context.getString(R.string.daewoo_g2x_s),context.getString(R.string.daewoo_g2x_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_arcadia),context.getString(R.string.daewoo_arcadia_s),context.getString(R.string.daewoo_arcadia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_espero),context.getString(R.string.daewoo_espero_s),context.getString(R.string.daewoo_espero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_istana),context.getString(R.string.daewoo_istana_s),context.getString(R.string.daewoo_istana_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_evanda),context.getString(R.string.daewoo_evanda_s),context.getString(R.string.daewoo_evanda_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_prince),context.getString(R.string.daewoo_prince_s),context.getString(R.string.daewoo_prince_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_tacuma),context.getString(R.string.daewoo_tacuma_s),context.getString(R.string.daewoo_tacuma_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_tosca),context.getString(R.string.daewoo_tosca_s),context.getString(R.string.daewoo_tosca_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_tico),context.getString(R.string.daewoo_tico_s),context.getString(R.string.daewoo_tico_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_juliet),context.getString(R.string.daewoo_juliet_s),context.getString(R.string.daewoo_juliet_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_gentra),context.getString(R.string.daewoo_gentra_s),context.getString(R.string.daewoo_gentra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_damas),context.getString(R.string.daewoo_damas_s),context.getString(R.string.daewoo_damas_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_racer),context.getString(R.string.daewoo_racer_s),context.getString(R.string.daewoo_racer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_rezzo),context.getString(R.string.daewoo_rezzo_s),context.getString(R.string.daewoo_rezzo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_zaz),context.getString(R.string.daewoo_zaz_s),context.getString(R.string.daewoo_zaz_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_statesman),context.getString(R.string.daewoo_statesman_s),context.getString(R.string.daewoo_statesman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_super_salon),context.getString(R.string.daewoo_super_salon_s),context.getString(R.string.daewoo_super_salon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_cielo),context.getString(R.string.daewoo_cielo_s),context.getString(R.string.daewoo_cielo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_chairman),context.getString(R.string.daewoo_chairman_s),context.getString(R.string.daewoo_chairman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_kalos),context.getString(R.string.daewoo_kalos_s),context.getString(R.string.daewoo_kalos_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_labo),context.getString(R.string.daewoo_labo_s),context.getString(R.string.daewoo_labo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_lacetti),context.getString(R.string.daewoo_lacetti_s),context.getString(R.string.daewoo_lacetti_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_lanos),context.getString(R.string.daewoo_lanos_s),context.getString(R.string.daewoo_lanos_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_lanos_1),context.getString(R.string.daewoo_lanos_1_s),context.getString(R.string.daewoo_lanos_1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_leganza),context.getString(R.string.daewoo_leganza_s),context.getString(R.string.daewoo_leganza_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_lemans),context.getString(R.string.daewoo_lemans_s),context.getString(R.string.daewoo_lemans_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_matiz),context.getString(R.string.daewoo_matiz_s),context.getString(R.string.daewoo_matiz_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_magnus),context.getString(R.string.daewoo_magnus_s),context.getString(R.string.daewoo_magnus_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_musso),context.getString(R.string.daewoo_musso_s),context.getString(R.string.daewoo_musso_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_nexia),context.getString(R.string.daewoo_nexia_s),context.getString(R.string.daewoo_nexia_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_nubira),context.getString(R.string.daewoo_nubira_s),context.getString(R.string.daewoo_nubira_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_windstorm),context.getString(R.string.daewoo_windstorm_s),context.getString(R.string.daewoo_windstorm_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_bf_106),context.getString(R.string.daewoo_bf_106_s),context.getString(R.string.daewoo_bf_106_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.daewoo_other),context.getString(R.string.daewoo_other_s),context.getString(R.string.daewoo_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.dodge)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_avenger),context.getString(R.string.dodge_avenger_s),context.getString(R.string.dodge_avenger_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_intrepid),context.getString(R.string.dodge_intrepid_s),context.getString(R.string.dodge_intrepid_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_charger),context.getString(R.string.dodge_charger_s),context.getString(R.string.dodge_charger_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_challenger),context.getString(R.string.dodge_challenger_s),context.getString(R.string.dodge_challenger_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_journey),context.getString(R.string.dodge_journey_s),context.getString(R.string.dodge_journey_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_dakota),context.getString(R.string.dodge_dakota_s),context.getString(R.string.dodge_dakota_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_daytona),context.getString(R.string.dodge_daytona_s),context.getString(R.string.dodge_daytona_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_durango),context.getString(R.string.dodge_durango_s),context.getString(R.string.dodge_durango_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_dynasty),context.getString(R.string.dodge_dynasty_s),context.getString(R.string.dodge_dynasty_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_ram),context.getString(R.string.dodge_ram_s),context.getString(R.string.dodge_ram_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_spirit),context.getString(R.string.dodge_spirit_s),context.getString(R.string.dodge_spirit_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_stratus),context.getString(R.string.dodge_stratus_s),context.getString(R.string.dodge_stratus_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_stealth),context.getString(R.string.dodge_stealth_s),context.getString(R.string.dodge_stealth_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_shadow),context.getString(R.string.dodge_shadow_s),context.getString(R.string.dodge_shadow_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_grand_caravan),context.getString(R.string.dodge_grand_caravan_s),context.getString(R.string.dodge_grand_caravan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_caliber),context.getString(R.string.dodge_caliber_s),context.getString(R.string.dodge_caliber_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_magnum),context.getString(R.string.dodge_magnum_s),context.getString(R.string.dodge_magnum_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_monaco),context.getString(R.string.dodge_monaco_s),context.getString(R.string.dodge_monaco_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_nitro),context.getString(R.string.dodge_nitro_s),context.getString(R.string.dodge_nitro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_neon),context.getString(R.string.dodge_neon_s),context.getString(R.string.dodge_neon_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_dart),context.getString(R.string.dodge_dart_s),context.getString(R.string.dodge_dart_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_power_wagon),context.getString(R.string.dodge_power_wagon_s),context.getString(R.string.dodge_power_wagon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dodge_other),context.getString(R.string.dodge_other_s),context.getString(R.string.dodge_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.rover)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_lr4),context.getString(R.string.land_rover_lr4_s),context.getString(R.string.land_rover_lr4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_discovery),context.getString(R.string.land_rover_discovery_s),context.getString(R.string.land_rover_discovery_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_discovery_sport),context.getString(R.string.land_rover_discovery_sport_s),context.getString(R.string.land_rover_discovery_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_defender),context.getString(R.string.land_rover_defender_s),context.getString(R.string.land_rover_defender_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_hse),context.getString(R.string.land_rover_range_rover_hse_s),context.getString(R.string.land_rover_range_rover_hse_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_evoque),context.getString(R.string.land_rover_range_rover_evoque_s),context.getString(R.string.land_rover_range_rover_evoque_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_sport),context.getString(R.string.land_rover_range_rover_sport_s),context.getString(R.string.land_rover_range_rover_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_vogue),context.getString(R.string.land_rover_range_rover_vogue_s),context.getString(R.string.land_rover_range_rover_vogue_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_velar),context.getString(R.string.land_rover_range_rover_velar_s),context.getString(R.string.land_rover_range_rover_velar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover),context.getString(R.string.land_rover_range_rover_s),context.getString(R.string.land_rover_range_rover_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_freelander),context.getString(R.string.land_rover_freelander_s),context.getString(R.string.land_rover_freelander_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_other),context.getString(R.string.land_rover_other_s),context.getString(R.string.land_rover_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.rolls_royce)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_park_ward),context.getString(R.string.rolls_royce_park_ward_s),context.getString(R.string.rolls_royce_park_ward_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_wraith),context.getString(R.string.rolls_royce_wraith_s),context.getString(R.string.rolls_royce_wraith_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_silver_spur),context.getString(R.string.rolls_royce_silver_spur_s),context.getString(R.string.rolls_royce_silver_spur_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_ghost),context.getString(R.string.rolls_royce_ghost_s),context.getString(R.string.rolls_royce_ghost_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_phantom),context.getString(R.string.rolls_royce_phantom_s),context.getString(R.string.rolls_royce_phantom_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_corniche),context.getString(R.string.rolls_royce_corniche_s),context.getString(R.string.rolls_royce_corniche_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_dawn),context.getString(R.string.rolls_royce_dawn_s),context.getString(R.string.rolls_royce_dawn_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_pininfarina),context.getString(R.string.rolls_royce_pininfarina_s),context.getString(R.string.rolls_royce_pininfarina_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_silver_spirit),context.getString(R.string.rolls_royce_silver_spirit_s),context.getString(R.string.rolls_royce_silver_spirit_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.rolls_royce_other),context.getString(R.string.rolls_royce_other_s),context.getString(R.string.rolls_royce_other_ar)));
//
//        }
//        if (carMake.equals(context.getString(R.string.renault)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_4),context.getString(R.string.renault_4_s),context.getString(R.string.renault_4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_5),context.getString(R.string.renault_5_s),context.getString(R.string.renault_5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_6),context.getString(R.string.renault_6_s),context.getString(R.string.renault_6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_9),context.getString(R.string.renault_9_s),context.getString(R.string.renault_9_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_11),context.getString(R.string.renault_11_s),context.getString(R.string.renault_11_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_12),context.getString(R.string.renault_12_s),context.getString(R.string.renault_12_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_14),context.getString(R.string.renault_14_s),context.getString(R.string.renault_14_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_15),context.getString(R.string.renault_15_s),context.getString(R.string.renault_15_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_16),context.getString(R.string.renault_16_s),context.getString(R.string.renault_16_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_17),context.getString(R.string.renault_17_s),context.getString(R.string.renault_17_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_18),context.getString(R.string.renault_18_s),context.getString(R.string.renault_18_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_19),context.getString(R.string.renault_19_s),context.getString(R.string.renault_19_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_20),context.getString(R.string.renault_20_s),context.getString(R.string.renault_20_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_21),context.getString(R.string.renault_21_s),context.getString(R.string.renault_21_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_25),context.getString(R.string.renault_25_s),context.getString(R.string.renault_25_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_30),context.getString(R.string.renault_30_s),context.getString(R.string.renault_30_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_espace),context.getString(R.string.renault_espace_s),context.getString(R.string.renault_espace_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_avantime),context.getString(R.string.renault_avantime_s),context.getString(R.string.renault_avantime_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_express),context.getString(R.string.renault_express_s),context.getString(R.string.renault_express_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_estafette),context.getString(R.string.renault_estafette_s),context.getString(R.string.renault_estafette_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_traviq),context.getString(R.string.renault_traviq_s),context.getString(R.string.renault_traviq_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_twizy),context.getString(R.string.renault_twizy_s),context.getString(R.string.renault_twizy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_twingo),context.getString(R.string.renault_twingo_s),context.getString(R.string.renault_twingo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_duster),context.getString(R.string.renault_duster_s),context.getString(R.string.renault_duster_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_dacia),context.getString(R.string.renault_dacia_s),context.getString(R.string.renault_dacia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_dokker_van),context.getString(R.string.renault_dokker_van_s),context.getString(R.string.renault_dokker_van_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_rapide),context.getString(R.string.renault_rapide_s),context.getString(R.string.renault_rapide_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_rainbow),context.getString(R.string.renault_rainbow_s),context.getString(R.string.renault_rainbow_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_rodeo),context.getString(R.string.renault_rodeo_s),context.getString(R.string.renault_rodeo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_zoe),context.getString(R.string.renault_zoe_s),context.getString(R.string.renault_zoe_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_safran),context.getString(R.string.renault_safran_s),context.getString(R.string.renault_safran_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_sandero),context.getString(R.string.renault_sandero_s),context.getString(R.string.renault_sandero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_sport_spider),context.getString(R.string.renault_sport_spider_s),context.getString(R.string.renault_sport_spider_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_symbol),context.getString(R.string.renault_symbol_s),context.getString(R.string.renault_symbol_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_scenic),context.getString(R.string.renault_scenic_s),context.getString(R.string.renault_scenic_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_grand_scenic),context.getString(R.string.renault_grand_scenic_s),context.getString(R.string.renault_grand_scenic_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_fluence),context.getString(R.string.renault_fluence_s),context.getString(R.string.renault_fluence_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_fuego),context.getString(R.string.renault_fuego_s),context.getString(R.string.renault_fuego_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_vel_satis),context.getString(R.string.renault_vel_satis_s),context.getString(R.string.renault_vel_satis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_kangoo),context.getString(R.string.renault_kangoo_s),context.getString(R.string.renault_kangoo_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_clio),context.getString(R.string.renault_clio_s),context.getString(R.string.renault_clio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_koleos),context.getString(R.string.renault_koleos_s),context.getString(R.string.renault_koleos_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_latitude),context.getString(R.string.renault_latitude_s),context.getString(R.string.renault_latitude_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_laguna),context.getString(R.string.renault_laguna_s),context.getString(R.string.renault_laguna_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_logan),context.getString(R.string.renault_logan_s),context.getString(R.string.renault_logan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_master),context.getString(R.string.renault_master_s),context.getString(R.string.renault_master_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_modus),context.getString(R.string.renault_modus_s),context.getString(R.string.renault_modus_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_megane),context.getString(R.string.renault_megane_s),context.getString(R.string.renault_megane_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_medallion),context.getString(R.string.renault_medallion_s),context.getString(R.string.renault_medallion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_captur),context.getString(R.string.renault_captur_s),context.getString(R.string.renault_captur_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.renault_other),context.getString(R.string.renault_other_s),context.getString(R.string.renault_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.saab)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_x9_2),context.getString(R.string.saad_x9_2_s),context.getString(R.string.saad_x9_2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_vector9_7),context.getString(R.string.saad_vector9_7_s),context.getString(R.string.saad_vector9_7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_x9_7),context.getString(R.string.saad_x9_7_s),context.getString(R.string.saad_x9_7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_90),context.getString(R.string.saad_90_s),context.getString(R.string.saad_90_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_93),context.getString(R.string.saad_93_s),context.getString(R.string.saad_93_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_95),context.getString(R.string.saad_95_s),context.getString(R.string.saad_95_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_96),context.getString(R.string.saad_96_s),context.getString(R.string.saad_96_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_99),context.getString(R.string.saad_99_s),context.getString(R.string.saad_99_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_900),context.getString(R.string.saad_900_s),context.getString(R.string.saad_900_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_9000),context.getString(R.string.saad_9000_s),context.getString(R.string.saad_9000_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.saad_other),context.getString(R.string.saad_other_s),context.getString(R.string.saad_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.saturn)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_ls),context.getString(R.string.saturn_ls_s),context.getString(R.string.saturn_ls_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_lw),context.getString(R.string.saturn_lw_s),context.getString(R.string.saturn_lw_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_sc),context.getString(R.string.saturn_sc_s),context.getString(R.string.saturn_sc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_sl),context.getString(R.string.saturn_sl_s),context.getString(R.string.saturn_sl_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_outlook),context.getString(R.string.saturn_outlook_s),context.getString(R.string.saturn_outlook_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_astra),context.getString(R.string.saturn_astra_s),context.getString(R.string.saturn_astra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_lon),context.getString(R.string.saturn_lon_s),context.getString(R.string.saturn_lon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_aura),context.getString(R.string.saturn_aura_s),context.getString(R.string.saturn_aura_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_relay),context.getString(R.string.saturn_relay_s),context.getString(R.string.saturn_relay_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_sky),context.getString(R.string.saturn_sky_s),context.getString(R.string.saturn_sky_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_view),context.getString(R.string.saturn_view_s),context.getString(R.string.saturn_view_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saturn_other),context.getString(R.string.saturn_other_s),context.getString(R.string.saturn_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.ssang_yong)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_actyon),context.getString(R.string.ssang_yong_actyon_s),context.getString(R.string.ssang_yong_actyon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_tiger),context.getString(R.string.ssang_yong_tiger_s),context.getString(R.string.ssang_yong_tiger_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_chairman),context.getString(R.string.ssang_yong_chairman_s),context.getString(R.string.ssang_yong_chairman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_rodius),context.getString(R.string.ssang_yong_rodius_s),context.getString(R.string.ssang_yong_rodius_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_rexton),context.getString(R.string.ssang_yong_rexton_s),context.getString(R.string.ssang_yong_rexton_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_family),context.getString(R.string.ssang_yong_family_s),context.getString(R.string.ssang_yong_family_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_kallista),context.getString(R.string.ssang_yong_kallista_s),context.getString(R.string.ssang_yong_kallista_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_kyron),context.getString(R.string.ssang_yong_kyron_s),context.getString(R.string.ssang_yong_kyron_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_musso),context.getString(R.string.ssang_yong_musso_s),context.getString(R.string.ssang_yong_musso_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ssang_yong_other),context.getString(R.string.ssang_yong_other_s),context.getString(R.string.ssang_yong_other_ar)));
//
//        }
//        if (carMake.equals(context.getString(R.string.citroen)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c),context.getString(R.string.citroen_c_s),context.getString(R.string.citroen_c_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c_zero),context.getString(R.string.citroen_c_zero_s),context.getString(R.string.citroen_c_zero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c1),context.getString(R.string.citroen_c1_s),context.getString(R.string.citroen_c1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c15),context.getString(R.string.citroen_c15_s),context.getString(R.string.citroen_c15_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c2),context.getString(R.string.citroen_c2_s),context.getString(R.string.citroen_c2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c25),context.getString(R.string.citroen_c25_s),context.getString(R.string.citroen_c25_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c3),context.getString(R.string.citroen_c3_s),context.getString(R.string.citroen_c3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c35),context.getString(R.string.citroen_c35_s),context.getString(R.string.citroen_c35_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c4),context.getString(R.string.citroen_c4_s),context.getString(R.string.citroen_c4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c5),context.getString(R.string.citroen_c5_s),context.getString(R.string.citroen_c5_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c6),context.getString(R.string.citroen_c6_s),context.getString(R.string.citroen_c6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c8),context.getString(R.string.citroen_c8_s),context.getString(R.string.citroen_c8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_cx),context.getString(R.string.citroen_cx_s),context.getString(R.string.citroen_cx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ds),context.getString(R.string.citroen_ds_s),context.getString(R.string.citroen_ds_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ds2),context.getString(R.string.citroen_ds2_s),context.getString(R.string.citroen_ds2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ds4),context.getString(R.string.citroen_ds4_s),context.getString(R.string.citroen_ds4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ds5),context.getString(R.string.citroen_ds5_s),context.getString(R.string.citroen_ds5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ds9),context.getString(R.string.citroen_ds9_s),context.getString(R.string.citroen_ds9_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_g),context.getString(R.string.citroen_g_s),context.getString(R.string.citroen_g_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_gs),context.getString(R.string.citroen_gs_s),context.getString(R.string.citroen_gs_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_gsa),context.getString(R.string.citroen_gsa_s),context.getString(R.string.citroen_gsa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_gt),context.getString(R.string.citroen_gt_s),context.getString(R.string.citroen_gt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_2cv),context.getString(R.string.citroen_2cv_s),context.getString(R.string.citroen_2cv_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ax),context.getString(R.string.citroen_ax_s),context.getString(R.string.citroen_ax_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_bx),context.getString(R.string.citroen_bx_s),context.getString(R.string.citroen_bx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ln),context.getString(R.string.citroen_ln_s),context.getString(R.string.citroen_ln_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_lna),context.getString(R.string.citroen_lna_s),context.getString(R.string.citroen_lna_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_xm),context.getString(R.string.citroen_xm_s),context.getString(R.string.citroen_xm_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_zx),context.getString(R.string.citroen_zx_s),context.getString(R.string.citroen_zx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_ami),context.getString(R.string.citroen_ami_s),context.getString(R.string.citroen_ami_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_acadiane),context.getString(R.string.citroen_acadiane_s),context.getString(R.string.citroen_acadiane_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_xsara),context.getString(R.string.citroen_xsara_s),context.getString(R.string.citroen_xsara_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_xsara_picasso),context.getString(R.string.citroen_xsara_picasso_s),context.getString(R.string.citroen_xsara_picasso_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_xantia),context.getString(R.string.citroen_xantia_s),context.getString(R.string.citroen_xantia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_evasion),context.getString(R.string.citroen_evasion_s),context.getString(R.string.citroen_evasion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_berlingo),context.getString(R.string.citroen_berlingo_s),context.getString(R.string.citroen_berlingo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c3_picasso),context.getString(R.string.citroen_c3_picasso_s),context.getString(R.string.citroen_c3_picasso_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c4_picasso),context.getString(R.string.citroen_c4_picasso_s),context.getString(R.string.citroen_c4_picasso_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_jumper),context.getString(R.string.citroen_jumper_s),context.getString(R.string.citroen_jumper_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_jumpy),context.getString(R.string.citroen_jumpy_s),context.getString(R.string.citroen_jumpy_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_dyane),context.getString(R.string.citroen_dyane_s),context.getString(R.string.citroen_dyane_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_saxo),context.getString(R.string.citroen_saxo_s),context.getString(R.string.citroen_saxo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_c_crosser),context.getString(R.string.citroen_c_crosse_sr),context.getString(R.string.citroen_c_crosser_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_synergie),context.getString(R.string.citroen_synergie_s),context.getString(R.string.citroen_synergie_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_faf),context.getString(R.string.citroen_faf_s),context.getString(R.string.citroen_faf_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_visa),context.getString(R.string.citroen_visa_s),context.getString(R.string.citroen_visa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_mehari),context.getString(R.string.citroen_mehari_s),context.getString(R.string.citroen_mehari_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_nemo),context.getString(R.string.citroen_nemo_s),context.getString(R.string.citroen_nemo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.citroen_other),context.getString(R.string.citroen_other_s),context.getString(R.string.citroen_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.skoda)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_120_gls),context.getString(R.string.skoda_120_gls_s),context.getString(R.string.skoda_120_gls_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_octavia),context.getString(R.string.skoda_octavia_s),context.getString(R.string.skoda_octavia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_praktik),context.getString(R.string.skoda_praktik_s),context.getString(R.string.skoda_praktik_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_rapide),context.getString(R.string.skoda_rapide_s),context.getString(R.string.skoda_rapide_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_roomster),context.getString(R.string.skoda_roomster_s),context.getString(R.string.skoda_roomster_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_superb),context.getString(R.string.skoda_superb_s),context.getString(R.string.skoda_superb_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_fabia),context.getString(R.string.skoda_fabia_s),context.getString(R.string.skoda_fabia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_favorit),context.getString(R.string.skoda_favorit_s),context.getString(R.string.skoda_favorit_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_forman),context.getString(R.string.skoda_forman_s),context.getString(R.string.skoda_forman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_felicia),context.getString(R.string.skoda_felicia_s),context.getString(R.string.skoda_felicia_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_felicia_combi),context.getString(R.string.skoda_felicia_combi_s),context.getString(R.string.skoda_felicia_combi_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_yeti),context.getString(R.string.skoda_yeti_s),context.getString(R.string.skoda_yeti_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.skoda_other),context.getString(R.string.skoda_other_s),context.getString(R.string.skoda_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.subaru)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_r1),context.getString(R.string.subaru_r1_s),context.getString(R.string.subaru_r1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_r2),context.getString(R.string.subaru_r2_s),context.getString(R.string.subaru_r2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_sti),context.getString(R.string.subaru_sti_s),context.getString(R.string.subaru_sti_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_svx),context.getString(R.string.subaru_svx_s),context.getString(R.string.subaru_svx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_wrx),context.getString(R.string.subaru_wrx_s),context.getString(R.string.subaru_wrx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_xt),context.getString(R.string.subaru_xt_s),context.getString(R.string.subaru_xt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_xv),context.getString(R.string.subaru_xv_s),context.getString(R.string.subaru_xv_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_outback),context.getString(R.string.subaru_outback_s),context.getString(R.string.subaru_outback_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_alcyone),context.getString(R.string.subaru_alcyone_s),context.getString(R.string.subaru_alcyone_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_exiga),context.getString(R.string.subaru_exiga_s),context.getString(R.string.subaru_exiga_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_impreza),context.getString(R.string.subaru_impreza_s),context.getString(R.string.subaru_impreza_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_baja),context.getString(R.string.subaru_baja_s),context.getString(R.string.subaru_baja_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_pleo),context.getString(R.string.subaru_pleo_s),context.getString(R.string.subaru_pleo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_bistro),context.getString(R.string.subaru_bistro_s),context.getString(R.string.subaru_bistro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_traviq),context.getString(R.string.subaru_traviq_s),context.getString(R.string.subaru_traviq_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_tribeca),context.getString(R.string.subaru_tribeca_s),context.getString(R.string.subaru_tribeca_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_trezia),context.getString(R.string.subaru_trezia_s),context.getString(R.string.subaru_trezia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_justy),context.getString(R.string.subaru_justy_s),context.getString(R.string.subaru_justy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_domingo),context.getString(R.string.subaru_domingo_s),context.getString(R.string.subaru_domingo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_dias),context.getString(R.string.subaru_dias_s),context.getString(R.string.subaru_dias_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_dex),context.getString(R.string.subaru_dex_s),context.getString(R.string.subaru_dex_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_stella),context.getString(R.string.subaru_stella_s),context.getString(R.string.subaru_stella_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_forester),context.getString(R.string.subaru_forester_s),context.getString(R.string.subaru_forester_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_vivio),context.getString(R.string.subaru_vivio_s),context.getString(R.string.subaru_vivio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_lucra),context.getString(R.string.subaru_lucra_s),context.getString(R.string.subaru_lucra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_libero),context.getString(R.string.subaru_libero_s),context.getString(R.string.subaru_libero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_legacy),context.getString(R.string.subaru_legacy_s),context.getString(R.string.subaru_legacy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.subaru_other),context.getString(R.string.subaru_other_s),context.getString(R.string.subaru_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.suzuki)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_apv),context.getString(R.string.suzuki_apv_s),context.getString(R.string.suzuki_apv_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_sx4),context.getString(R.string.suzuki_sx4_s),context.getString(R.string.suzuki_sx4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_x90),context.getString(R.string.suzuki_x90_s),context.getString(R.string.suzuki_x90_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_xl7),context.getString(R.string.suzuki_xl7_s),context.getString(R.string.suzuki_xl7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_wagon_r),context.getString(R.string.suzuki_wagon_r_s),context.getString(R.string.suzuki_wagon_r_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_alto),context.getString(R.string.suzuki_alto_s),context.getString(R.string.suzuki_alto_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_mr_wagon),context.getString(R.string.suzuki_mr_wagon_s),context.getString(R.string.suzuki_mr_wagon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_ertiga),context.getString(R.string.suzuki_ertiga_s),context.getString(R.string.suzuki_ertiga_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_ideal),context.getString(R.string.suzuki_ideal_s),context.getString(R.string.suzuki_ideal_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_aerio),context.getString(R.string.suzuki_aerio_s),context.getString(R.string.suzuki_aerio_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_ignis),context.getString(R.string.suzuki_ignis_s),context.getString(R.string.suzuki_ignis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_every),context.getString(R.string.suzuki_every_s),context.getString(R.string.suzuki_every_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_every_landy),context.getString(R.string.suzuki_every_landy_s),context.getString(R.string.suzuki_every_landy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_baleno),context.getString(R.string.suzuki_baleno_s),context.getString(R.string.suzuki_baleno_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_grand_vitara),context.getString(R.string.suzuki_grand_vitara_s),context.getString(R.string.suzuki_grand_vitara_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_jimny),context.getString(R.string.suzuki_jimny_s),context.getString(R.string.suzuki_jimny_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_reno),context.getString(R.string.suzuki_reno_s),context.getString(R.string.suzuki_reno_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_samurai),context.getString(R.string.suzuki_samurai_s),context.getString(R.string.suzuki_samurai_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_sidekick),context.getString(R.string.suzuki_sidekick_s),context.getString(R.string.suzuki_sidekick_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_splash),context.getString(R.string.suzuki_splash_s),context.getString(R.string.suzuki_splash_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_super_carry),context.getString(R.string.suzuki_super_carry_s),context.getString(R.string.suzuki_super_carry_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_swift),context.getString(R.string.suzuki_swift_s),context.getString(R.string.suzuki_swift_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_ciaz),context.getString(R.string.suzuki_ciaz_s),context.getString(R.string.suzuki_ciaz_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_cervo),context.getString(R.string.suzuki_cervo_s),context.getString(R.string.suzuki_cervo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_celerio),context.getString(R.string.suzuki_celerio_s),context.getString(R.string.suzuki_celerio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_forenza),context.getString(R.string.suzuki_forenza_s),context.getString(R.string.suzuki_forenza_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_vitara),context.getString(R.string.suzuki_vitara_s),context.getString(R.string.suzuki_vitara_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_verona),context.getString(R.string.suzuki_verona_s),context.getString(R.string.suzuki_verona_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_cappuccino),context.getString(R.string.suzuki_cappuccino_s),context.getString(R.string.suzuki_cappuccino_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_cultus_wagon),context.getString(R.string.suzuki_cultus_wagon_s),context.getString(R.string.suzuki_cultus_wagon_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_kei),context.getString(R.string.suzuki_kei_s),context.getString(R.string.suzuki_kei_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_kizashi),context.getString(R.string.suzuki_kizashi_s),context.getString(R.string.suzuki_kizashi_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_liana),context.getString(R.string.suzuki_liana_s),context.getString(R.string.suzuki_liana_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_carry),context.getString(R.string.suzuki_carry_s),context.getString(R.string.suzuki_carry_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_sj_samurai),context.getString(R.string.suzuki_sj_samurai_s),context.getString(R.string.suzuki_sj_samurai_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.suzuki_other),context.getString(R.string.suzuki_other_s),context.getString(R.string.suzuki_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.seat)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_132),context.getString(R.string.seat_132_s),context.getString(R.string.seat_132_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_133),context.getString(R.string.seat_133_s),context.getString(R.string.seat_133_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_altea),context.getString(R.string.seat_altea_s),context.getString(R.string.seat_altea_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_ibiza),context.getString(R.string.seat_ibiza_s),context.getString(R.string.seat_ibiza_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_arosa),context.getString(R.string.seat_arosa_s),context.getString(R.string.seat_arosa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_exeo),context.getString(R.string.seat_exeo_s),context.getString(R.string.seat_exeo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_alhambra),context.getString(R.string.seat_alhambra_s),context.getString(R.string.seat_alhambra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_toledo),context.getString(R.string.seat_toledo_s),context.getString(R.string.seat_toledo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_terra),context.getString(R.string.seat_terra_s),context.getString(R.string.seat_terra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_ronda),context.getString(R.string.seat_ronda_s),context.getString(R.string.seat_ronda_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_fura),context.getString(R.string.seat_fura_s),context.getString(R.string.seat_fura_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_cordoba),context.getString(R.string.seat_cordoba_s),context.getString(R.string.seat_cordoba_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_leone),context.getString(R.string.seat_leone_s),context.getString(R.string.seat_leone_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_marbella),context.getString(R.string.seat_marbella_s),context.getString(R.string.seat_marbella_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.seat_other),context.getString(R.string.seat_other_s),context.getString(R.string.seat_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.chery)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_a11),context.getString(R.string.chery_a11_s),context.getString(R.string.chery_a11_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_a113),context.getString(R.string.chery_a113_s),context.getString(R.string.chery_a113_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_a5),context.getString(R.string.chery_a5_s),context.getString(R.string.chery_a5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_a620),context.getString(R.string.chery_a620_s),context.getString(R.string.chery_a620_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_b11),context.getString(R.string.chery_b11_s),context.getString(R.string.chery_b11_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_m11),context.getString(R.string.chery_m11_s),context.getString(R.string.chery_m11_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_qq),context.getString(R.string.chery_qq_s),context.getString(R.string.chery_qq_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_qq6),context.getString(R.string.chery_qq6_s),context.getString(R.string.chery_qq6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_amulet),context.getString(R.string.chery_amulet_s),context.getString(R.string.chery_amulet_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_oriental_sun),context.getString(R.string.chery_oriental_sun_s),context.getString(R.string.chery_oriental_sun_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_tiggo),context.getString(R.string.chery_tiggo_s),context.getString(R.string.chery_tiggo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_fura),context.getString(R.string.chery_fura_s),context.getString(R.string.chery_fura_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_cross_easter),context.getString(R.string.chery_cross_easter_s),context.getString(R.string.chery_cross_easter_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chery_other),context.getString(R.string.chery_other_s),context.getString(R.string.chery_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.chevrolat)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_c10),context.getString(R.string.chevrolet_c10_s),context.getString(R.string.chevrolet_c10_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_hhr),context.getString(R.string.chevrolet_hhr_s),context.getString(R.string.chevrolet_hhr_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_luv_d_max),context.getString(R.string.chevrolet_luv_d_max_s),context.getString(R.string.chevrolet_luv_d_max_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_s_10),context.getString(R.string.chevrolet_s_10_s),context.getString(R.string.chevrolet_s_10_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_ssr),context.getString(R.string.chevrolet_ssr_s),context.getString(R.string.chevrolet_ssr_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_astra),context.getString(R.string.chevrolet_astra_s),context.getString(R.string.chevrolet_astra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_aveo),context.getString(R.string.chevrolet_aveo_s),context.getString(R.string.chevrolet_aveo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_omega),context.getString(R.string.chevrolet_omega_s),context.getString(R.string.chevrolet_omega_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_uplander),context.getString(R.string.chevrolet_uplander_s),context.getString(R.string.chevrolet_uplander_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_epica),context.getString(R.string.chevrolet_epica_s),context.getString(R.string.chevrolet_epica_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_express),context.getString(R.string.chevrolet_express_s),context.getString(R.string.chevrolet_express_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_astro),context.getString(R.string.chevrolet_astro_s),context.getString(R.string.chevrolet_astro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_avalanche),context.getString(R.string.chevrolet_avalanche_s),context.getString(R.string.chevrolet_avalanche_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_explorer),context.getString(R.string.chevrolet_explorer_s),context.getString(R.string.chevrolet_explorer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_equinox),context.getString(R.string.chevrolet_equinox_s),context.getString(R.string.chevrolet_equinox_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_alero),context.getString(R.string.chevrolet_alero_s),context.getString(R.string.chevrolet_alero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_impala),context.getString(R.string.chevrolet_impala_s),context.getString(R.string.chevrolet_impala_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_optra),context.getString(R.string.chevrolet_optra_s),context.getString(R.string.chevrolet_optra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_evenda),context.getString(R.string.chevrolet_evenda_s),context.getString(R.string.chevrolet_evenda_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_prizm),context.getString(R.string.chevrolet_prizm_s),context.getString(R.string.chevrolet_prizm_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_blazer),context.getString(R.string.chevrolet_blazer_s),context.getString(R.string.chevrolet_blazer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_bolt),context.getString(R.string.chevrolet_bolt_s),context.getString(R.string.chevrolet_bolt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_beretta),context.getString(R.string.chevrolet_beretta_s),context.getString(R.string.chevrolet_beretta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_bel_air),context.getString(R.string.chevrolet_bel_air_s),context.getString(R.string.chevrolet_bel_air_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_travera),context.getString(R.string.chevrolet_travera_s),context.getString(R.string.chevrolet_travera_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_tracker),context.getString(R.string.chevrolet_tracker_s),context.getString(R.string.chevrolet_tracker_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_trax),context.getString(R.string.chevrolet_trax_s),context.getString(R.string.chevrolet_trax_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_trans_sport),context.getString(R.string.chevrolet_trans_sport_s),context.getString(R.string.chevrolet_trans_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_trailblazer),context.getString(R.string.chevrolet_trailblazer_s),context.getString(R.string.chevrolet_trailblazer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_geo_storm),context.getString(R.string.chevrolet_geo_storm_s),context.getString(R.string.chevrolet_geo_storm_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_rezzo),context.getString(R.string.chevrolet_rezzo_s),context.getString(R.string.chevrolet_rezzo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_zafira),context.getString(R.string.chevrolet_zafira_s),context.getString(R.string.chevrolet_zafira_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_sail),context.getString(R.string.chevrolet_sail_s),context.getString(R.string.chevrolet_sail_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_spark),context.getString(R.string.chevrolet_spark_s),context.getString(R.string.chevrolet_spark_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_sprint),context.getString(R.string.chevrolet_sprint_s),context.getString(R.string.chevrolet_sprint_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_silverado),context.getString(R.string.chevrolet_silverado_s),context.getString(R.string.chevrolet_silverado_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_suburban),context.getString(R.string.chevrolet_suburban_s),context.getString(R.string.chevrolet_suburban_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_sonic),context.getString(R.string.chevrolet_sonic_s),context.getString(R.string.chevrolet_sonic_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_celta),context.getString(R.string.chevrolet_celta_s),context.getString(R.string.chevrolet_celta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_celebrity),context.getString(R.string.chevrolet_celebrity_s),context.getString(R.string.chevrolet_celebrity_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_chevette),context.getString(R.string.chevrolet_chevette_s),context.getString(R.string.chevrolet_chevette_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_van),context.getString(R.string.chevrolet_van_s),context.getString(R.string.chevrolet_van_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_frontera),context.getString(R.string.chevrolet_frontera_s),context.getString(R.string.chevrolet_frontera_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_volt),context.getString(R.string.chevrolet_volt_s),context.getString(R.string.chevrolet_volt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_vectra),context.getString(R.string.chevrolet_vectra_s),context.getString(R.string.chevrolet_vectra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_venture),context.getString(R.string.chevrolet_venture_s),context.getString(R.string.chevrolet_venture_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_captiva),context.getString(R.string.chevrolet_captiva_s),context.getString(R.string.chevrolet_captiva_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_caprice),context.getString(R.string.chevrolet_caprice_s),context.getString(R.string.chevrolet_caprice_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_caprice_classic),context.getString(R.string.chevrolet_caprice_classic_s),context.getString(R.string.chevrolet_caprice_classic_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_cavalier),context.getString(R.string.chevrolet_cavalier_s),context.getString(R.string.chevrolet_cavalier_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_cruze),context.getString(R.string.chevrolet_cruze_s),context.getString(R.string.chevrolet_cruze_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_camaro),context.getString(R.string.chevrolet_camaro_s),context.getString(R.string.chevrolet_camaro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_cobalt),context.getString(R.string.chevrolet_cobalt_s),context.getString(R.string.chevrolet_cobalt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_corsa),context.getString(R.string.chevrolet_corsa_s),context.getString(R.string.chevrolet_corsa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_corsica),context.getString(R.string.chevrolet_corsica_s),context.getString(R.string.chevrolet_corsica_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_covette),context.getString(R.string.chevrolet_covette_s),context.getString(R.string.chevrolet_covette_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_colorado),context.getString(R.string.chevrolet_colorado_s),context.getString(R.string.chevrolet_colorado_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_lacetti),context.getString(R.string.chevrolet_lacetti_s),context.getString(R.string.chevrolet_lacetti_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_lanos),context.getString(R.string.chevrolet_lanos_s),context.getString(R.string.chevrolet_lanos_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_lumina),context.getString(R.string.chevrolet_lumina_s),context.getString(R.string.chevrolet_lumina_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_malibu),context.getString(R.string.chevrolet_malibu_s),context.getString(R.string.chevrolet_malibu_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_metro),context.getString(R.string.chevrolet_metro_s),context.getString(R.string.chevrolet_metro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_monte_carlo),context.getString(R.string.chevrolet_monte_carlo_s),context.getString(R.string.chevrolet_monte_carlo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_monza),context.getString(R.string.chevrolet_monza_s),context.getString(R.string.chevrolet_monza_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_nubira),context.getString(R.string.chevrolet_nubira_s),context.getString(R.string.chevrolet_nubira_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_niva),context.getString(R.string.chevrolet_niva_s),context.getString(R.string.chevrolet_niva_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_3100),context.getString(R.string.chevrolet_3100_s),context.getString(R.string.chevrolet_3100_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_4500),context.getString(R.string.chevrolet_4500_s),context.getString(R.string.chevrolet_4500_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_c1500),context.getString(R.string.chevrolet_c1500_s),context.getString(R.string.chevrolet_c1500_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_cheyenne),context.getString(R.string.chevrolet_cheyenne_s),context.getString(R.string.chevrolet_cheyenne_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_cr8),context.getString(R.string.chevrolet_cr8_s),context.getString(R.string.chevrolet_cr8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_el_camino),context.getString(R.string.chevrolet_el_camino_s),context.getString(R.string.chevrolet_el_camino_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chevrolet_other),context.getString(R.string.chevrolet_other_s),context.getString(R.string.chevrolet_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.ford)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_c_max),context.getString(R.string.ford_c_max_s),context.getString(R.string.ford_c_max_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_f_150),context.getString(R.string.ford_f_150_s),context.getString(R.string.ford_f_150_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_f_250),context.getString(R.string.ford_f_250_s),context.getString(R.string.ford_f_250_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_f_350),context.getString(R.string.ford_f_350_s),context.getString(R.string.ford_f_350_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_gt),context.getString(R.string.ford_gt_s),context.getString(R.string.ford_gt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_aurion),context.getString(R.string.ford_aurion_s),context.getString(R.string.ford_aurion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_aerostar),context.getString(R.string.ford_aerostar_s),context.getString(R.string.ford_aerostar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_escort),context.getString(R.string.ford_escort_s),context.getString(R.string.ford_escort_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_explorer),context.getString(R.string.ford_explorer_s),context.getString(R.string.ford_explorer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_s_max),context.getString(R.string.ford_s_max_s),context.getString(R.string.ford_s_max_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_aspire),context.getString(R.string.ford_aspire_s),context.getString(R.string.ford_aspire_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_escape),context.getString(R.string.ford_escape_s),context.getString(R.string.ford_escape_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_expedition),context.getString(R.string.ford_expedition_s),context.getString(R.string.ford_expedition_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_excursion),context.getString(R.string.ford_excursion_s),context.getString(R.string.ford_excursion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_edge),context.getString(R.string.ford_edge_s),context.getString(R.string.ford_edge_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_everest),context.getString(R.string.ford_everest_s),context.getString(R.string.ford_everest_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_econoline),context.getString(R.string.ford_econoline_s),context.getString(R.string.ford_econoline_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_ecosport),context.getString(R.string.ford_ecosport_s),context.getString(R.string.ford_ecosport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_econovan),context.getString(R.string.ford_econovan_s),context.getString(R.string.ford_econovan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_bronco),context.getString(R.string.ford_bronco_s),context.getString(R.string.ford_bronco_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_puma),context.getString(R.string.ford_puma_s),context.getString(R.string.ford_puma_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_taunus),context.getString(R.string.ford_taunus_s),context.getString(R.string.ford_taunus_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_transit),context.getString(R.string.ford_transit_s),context.getString(R.string.ford_transit_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_tourneo_connect),context.getString(R.string.ford_tourneo_connect_s),context.getString(R.string.ford_tourneo_connect_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_tempo),context.getString(R.string.ford_tempo_s),context.getString(R.string.ford_tempo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_thunder_bird),context.getString(R.string.ford_thunder_bird_s),context.getString(R.string.ford_thunder_bird_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_raptor),context.getString(R.string.ford_raptor_s),context.getString(R.string.ford_raptor_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_ranger),context.getString(R.string.ford_ranger_s),context.getString(R.string.ford_ranger_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_sport_trac),context.getString(R.string.ford_sport_trac_s),context.getString(R.string.ford_sport_trac_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_sport_truck_explorer),context.getString(R.string.ford_sport_truck_explorer_s),context.getString(R.string.ford_sport_truck_explorer_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_scorpio),context.getString(R.string.ford_scorpio_s),context.getString(R.string.ford_scorpio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_sierra),context.getString(R.string.ford_sierra_s),context.getString(R.string.ford_sierra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_shelby),context.getString(R.string.ford_shelby_s),context.getString(R.string.ford_shelby_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_galaxy),context.getString(R.string.ford_galaxy_s),context.getString(R.string.ford_galaxy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_granada),context.getString(R.string.ford_granada_s),context.getString(R.string.ford_granada_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_five_hundred),context.getString(R.string.ford_five_hundred_s),context.getString(R.string.ford_five_hundred_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_freestyle),context.getString(R.string.ford_freestyle_s),context.getString(R.string.ford_freestyle_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_focus),context.getString(R.string.ford_focus_s),context.getString(R.string.ford_focus_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_fox_rs),context.getString(R.string.ford_fox_rs_s),context.getString(R.string.ford_fox_rs_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_figo),context.getString(R.string.ford_figo_s),context.getString(R.string.ford_figo_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_fusion),context.getString(R.string.ford_fusion_s),context.getString(R.string.ford_fusion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_fiesta),context.getString(R.string.ford_fiesta_s),context.getString(R.string.ford_fiesta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_ka),context.getString(R.string.ford_ka_s),context.getString(R.string.ford_ka_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_capri),context.getString(R.string.ford_capri_s),context.getString(R.string.ford_capri_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_cougar),context.getString(R.string.ford_cougar_s),context.getString(R.string.ford_cougar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_crown_victoria),context.getString(R.string.ford_crown_victoria_s),context.getString(R.string.ford_crown_victoria_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_kuga),context.getString(R.string.ford_kuga_s),context.getString(R.string.ford_kuga_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_courier),context.getString(R.string.ford_courier_s),context.getString(R.string.ford_courier_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_contour),context.getString(R.string.ford_contour_s),context.getString(R.string.ford_contour_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_consul),context.getString(R.string.ford_consul_s),context.getString(R.string.ford_consul_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_laser),context.getString(R.string.ford_laser_s),context.getString(R.string.ford_laser_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_maverick),context.getString(R.string.ford_maverick_s),context.getString(R.string.ford_maverick_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_mustang),context.getString(R.string.ford_mustang_s),context.getString(R.string.ford_mustang_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_mondeo),context.getString(R.string.ford_mondeo_s),context.getString(R.string.ford_mondeo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_windstar),context.getString(R.string.ford_windstar_s),context.getString(R.string.ford_windstar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_f550),context.getString(R.string.ford_f550_s),context.getString(R.string.ford_f550_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_f450),context.getString(R.string.ford_f450_s),context.getString(R.string.ford_f450_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_e_350),context.getString(R.string.ford_e_350_s),context.getString(R.string.ford_e_350_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_e_450),context.getString(R.string.ford_e_450_s),context.getString(R.string.ford_e_450_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_flex),context.getString(R.string.ford_flex_s),context.getString(R.string.ford_flex_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_ltd),context.getString(R.string.ford_ltd_s),context.getString(R.string.ford_ltd_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_model_40),context.getString(R.string.ford_model_40_s),context.getString(R.string.ford_model_40_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_model_a),context.getString(R.string.ford_model_a_s),context.getString(R.string.ford_model_a_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_t_bucket),context.getString(R.string.ford_t_bucket_s),context.getString(R.string.ford_t_bucket_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ford_other),context.getString(R.string.ford_other_s),context.getString(R.string.ford_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.volvo)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_c),context.getString(R.string.volvo_c_s),context.getString(R.string.volvo_c_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_c30),context.getString(R.string.volvo_c30_s),context.getString(R.string.volvo_c30_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_c70),context.getString(R.string.volvo_c70_s),context.getString(R.string.volvo_c70_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_car_s),context.getString(R.string.volvo_car_s_s),context.getString(R.string.volvo_car_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_s40),context.getString(R.string.volvo_s40_s),context.getString(R.string.volvo_s40_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_s60),context.getString(R.string.volvo_s60_s),context.getString(R.string.volvo_s60_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_s70),context.getString(R.string.volvo_s70_s),context.getString(R.string.volvo_s70_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_s80),context.getString(R.string.volvo_s80_s),context.getString(R.string.volvo_s80_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_s90),context.getString(R.string.volvo_s90_s),context.getString(R.string.volvo_s90_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_v),context.getString(R.string.volvo_v_s),context.getString(R.string.volvo_v_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_v40),context.getString(R.string.volvo_v40_s),context.getString(R.string.volvo_v40_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_v50),context.getString(R.string.volvo_v50_s),context.getString(R.string.volvo_v50_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_v60),context.getString(R.string.volvo_v60_s),context.getString(R.string.volvo_v60_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_v70),context.getString(R.string.volvo_v70_s),context.getString(R.string.volvo_v70_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_v90),context.getString(R.string.volvo_v90_s),context.getString(R.string.volvo_v90_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_xc),context.getString(R.string.volvo_xc_s),context.getString(R.string.volvo_xc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_xc60),context.getString(R.string.volvo_xc60_s),context.getString(R.string.volvo_xc60_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_xc70),context.getString(R.string.volvo_xc70_s),context.getString(R.string.volvo_xc70_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_xc90),context.getString(R.string.volvo_xc90_s),context.getString(R.string.volvo_xc90_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_66),context.getString(R.string.volvo_66_s),context.getString(R.string.volvo_66_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_140),context.getString(R.string.volvo_140_s),context.getString(R.string.volvo_140_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_164),context.getString(R.string.volvo_164_s),context.getString(R.string.volvo_164_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_240),context.getString(R.string.volvo_240_s),context.getString(R.string.volvo_240_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_260),context.getString(R.string.volvo_260_s),context.getString(R.string.volvo_260_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_340),context.getString(R.string.volvo_340_s),context.getString(R.string.volvo_340_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_360),context.getString(R.string.volvo_360_s),context.getString(R.string.volvo_360_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_440),context.getString(R.string.volvo_440_s),context.getString(R.string.volvo_440_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_460),context.getString(R.string.volvo_460_s),context.getString(R.string.volvo_460_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_480),context.getString(R.string.volvo_480_s),context.getString(R.string.volvo_480_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_740),context.getString(R.string.volvo_740_s),context.getString(R.string.volvo_740_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_760),context.getString(R.string.volvo_760_s),context.getString(R.string.volvo_760_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_780),context.getString(R.string.volvo_780_s),context.getString(R.string.volvo_780_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_850),context.getString(R.string.volvo_850_s),context.getString(R.string.volvo_850_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_940),context.getString(R.string.volvo_940_s),context.getString(R.string.volvo_940_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_960),context.getString(R.string.volvo_960_s),context.getString(R.string.volvo_960_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_laplander),context.getString(R.string.volvo_laplander_s),context.getString(R.string.volvo_laplander_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_marcopolo),context.getString(R.string.volvo_marcopolo_s),context.getString(R.string.volvo_marcopolo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_p1800),context.getString(R.string.volvo_p1800_s),context.getString(R.string.volvo_p1800_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volvo_other),context.getString(R.string.volvo_other_s),context.getString(R.string.volvo_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.volkswagen)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_cc),context.getString(R.string.volkswagen_cc_s),context.getString(R.string.volkswagen_cc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_gti),context.getString(R.string.volkswagen_gti_s),context.getString(R.string.volkswagen_gti_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_w12),context.getString(R.string.volkswagen_w12_s),context.getString(R.string.volkswagen_w12_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_eos),context.getString(R.string.volkswagen_eos_s),context.getString(R.string.volkswagen_eos_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_lltis),context.getString(R.string.volkswagen_lltis_s),context.getString(R.string.volkswagen_lltis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_amarok),context.getString(R.string.volkswagen_amarok_s),context.getString(R.string.volkswagen_amarok_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_e_golf),context.getString(R.string.volkswagen_e_golf_s),context.getString(R.string.volkswagen_e_golf_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_parati),context.getString(R.string.volkswagen_parati_s),context.getString(R.string.volkswagen_parati_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_passat),context.getString(R.string.volkswagen_passat_s),context.getString(R.string.volkswagen_passat_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_bora),context.getString(R.string.volkswagen_bora_s),context.getString(R.string.volkswagen_bora_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_polo),context.getString(R.string.volkswagen_polo_s),context.getString(R.string.volkswagen_polo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_pointer),context.getString(R.string.volkswagen_pointer_s),context.getString(R.string.volkswagen_pointer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_beetle),context.getString(R.string.volkswagen_beetle_s),context.getString(R.string.volkswagen_beetle_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_taro),context.getString(R.string.volkswagen_taro_s),context.getString(R.string.volkswagen_taro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_transporter),context.getString(R.string.volkswagen_transporter_s),context.getString(R.string.volkswagen_transporter_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_touran),context.getString(R.string.volkswagen_touran_s),context.getString(R.string.volkswagen_touran_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_tiguan),context.getString(R.string.volkswagen_tiguan_s),context.getString(R.string.volkswagen_tiguan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_golf),context.getString(R.string.volkswagen_golf_s),context.getString(R.string.volkswagen_golf_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_golf_r),context.getString(R.string.volkswagen_golf_r_s),context.getString(R.string.volkswagen_golf_r_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_golf_plus),context.getString(R.string.volkswagen_golf_plus_s),context.getString(R.string.volkswagen_golf_plus_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_jetta),context.getString(R.string.volkswagen_jetta_s),context.getString(R.string.volkswagen_jetta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_routan),context.getString(R.string.volkswagen_routan_s),context.getString(R.string.volkswagen_routan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_saveiro),context.getString(R.string.volkswagen_saveiro_s),context.getString(R.string.volkswagen_saveiro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_santana),context.getString(R.string.volkswagen_santana_s),context.getString(R.string.volkswagen_santana_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_suran),context.getString(R.string.volkswagen_suran_s),context.getString(R.string.volkswagen_suran_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_scirocco),context.getString(R.string.volkswagen_scirocco_s),context.getString(R.string.volkswagen_scirocco_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_sharan),context.getString(R.string.volkswagen_sharan_s),context.getString(R.string.volkswagen_sharan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_touareg),context.getString(R.string.volkswagen_touareg_s),context.getString(R.string.volkswagen_touareg_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_gol),context.getString(R.string.volkswagen_gol_s),context.getString(R.string.volkswagen_gol_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_phaeton),context.getString(R.string.volkswagen_phaeton_s),context.getString(R.string.volkswagen_phaeton_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_fox),context.getString(R.string.volkswagen_fox_s),context.getString(R.string.volkswagen_fox_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_vento),context.getString(R.string.volkswagen_vento_s),context.getString(R.string.volkswagen_vento_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_caddy),context.getString(R.string.volkswagen_caddy_s),context.getString(R.string.volkswagen_caddy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_caravelle),context.getString(R.string.volkswagen_caravelle_s),context.getString(R.string.volkswagen_caravelle_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_california),context.getString(R.string.volkswagen_california_s),context.getString(R.string.volkswagen_california_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_crafter),context.getString(R.string.volkswagen_crafter_s),context.getString(R.string.volkswagen_crafter_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_crossfox),context.getString(R.string.volkswagen_crossfox_s),context.getString(R.string.volkswagen_crossfox_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_corrado),context.getString(R.string.volkswagen_corrado_s),context.getString(R.string.volkswagen_corrado_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_lupo),context.getString(R.string.volkswagen_lupo_s),context.getString(R.string.volkswagen_lupo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_multivan),context.getString(R.string.volkswagen_multivan_s),context.getString(R.string.volkswagen_multivan_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_1500),context.getString(R.string.volkswagen_1500_s),context.getString(R.string.volkswagen_1500_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_lt),context.getString(R.string.volkswagen_lt_s),context.getString(R.string.volkswagen_lt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_passat_cc),context.getString(R.string.volkswagen_passat_cc_s),context.getString(R.string.volkswagen_passat_cc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_t3_caravelle),context.getString(R.string.volkswagen_t3_caravelle_s),context.getString(R.string.volkswagen_t3_caravelle_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.volkswagen_other),context.getString(R.string.volkswagen_other_s),context.getString(R.string.volkswagen_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.fiat)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_124),context.getString(R.string.fiat_124_s),context.getString(R.string.fiat_124_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_126),context.getString(R.string.fiat_126_s),context.getString(R.string.fiat_126_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_127),context.getString(R.string.fiat_127_s),context.getString(R.string.fiat_127_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_131),context.getString(R.string.fiat_131_s),context.getString(R.string.fiat_131_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_500),context.getString(R.string.fiat_500_s),context.getString(R.string.fiat_500_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_500e),context.getString(R.string.fiat_500e_s),context.getString(R.string.fiat_500e_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_600),context.getString(R.string.fiat_600_s),context.getString(R.string.fiat_600_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_x_1_9),context.getString(R.string.fiat_x_1_9_s),context.getString(R.string.fiat_x_1_9_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_argenta),context.getString(R.string.fiat_argenta_s),context.getString(R.string.fiat_argenta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_ulysse),context.getString(R.string.fiat_ulysse_s),context.getString(R.string.fiat_ulysse_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_uno),context.getString(R.string.fiat_uno_s),context.getString(R.string.fiat_uno_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_albea),context.getString(R.string.fiat_albea_s),context.getString(R.string.fiat_albea_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_idea),context.getString(R.string.fiat_idea_s),context.getString(R.string.fiat_idea_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_barchetta),context.getString(R.string.fiat_barchetta_s),context.getString(R.string.fiat_barchetta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_palio),context.getString(R.string.fiat_palio_s),context.getString(R.string.fiat_palio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_panda),context.getString(R.string.fiat_panda_s),context.getString(R.string.fiat_panda_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_bravo),context.getString(R.string.fiat_bravo_s),context.getString(R.string.fiat_bravo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_bolognese),context.getString(R.string.fiat_bolognese_s),context.getString(R.string.fiat_bolognese_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_punto),context.getString(R.string.fiat_punto_s),context.getString(R.string.fiat_punto_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_petra),context.getString(R.string.fiat_petra_s),context.getString(R.string.fiat_petra_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_tipo),context.getString(R.string.fiat_tipo_s),context.getString(R.string.fiat_tipo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_tempra),context.getString(R.string.fiat_tempra_s),context.getString(R.string.fiat_tempra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_grande_punto),context.getString(R.string.fiat_grande_punto_s),context.getString(R.string.fiat_grande_punto_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_doblo),context.getString(R.string.fiat_doblo_s),context.getString(R.string.fiat_doblo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_dukato),context.getString(R.string.fiat_dukato_s),context.getString(R.string.fiat_dukato_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_duna),context.getString(R.string.fiat_duna_s),context.getString(R.string.fiat_duna_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_ritmo),context.getString(R.string.fiat_ritmo_s),context.getString(R.string.fiat_ritmo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_regata),context.getString(R.string.fiat_regata_s),context.getString(R.string.fiat_regata_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_zastava),context.getString(R.string.fiat_zastava_s),context.getString(R.string.fiat_zastava_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_strada),context.getString(R.string.fiat_strada_s),context.getString(R.string.fiat_strada_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_stilo),context.getString(R.string.fiat_stilo_s),context.getString(R.string.fiat_stilo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_sedici),context.getString(R.string.fiat_sedici_s),context.getString(R.string.fiat_sedici_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_cinquecento),context.getString(R.string.fiat_cinquecento_s),context.getString(R.string.fiat_cinquecento_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_seicento),context.getString(R.string.fiat_seicento_s),context.getString(R.string.fiat_seicento_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_siena),context.getString(R.string.fiat_siena_s),context.getString(R.string.fiat_siena_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_florida),context.getString(R.string.fiat_florida_s),context.getString(R.string.fiat_florida_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_fiorino),context.getString(R.string.fiat_fiorino_s),context.getString(R.string.fiat_fiorino_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_croma),context.getString(R.string.fiat_croma_s),context.getString(R.string.fiat_croma_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_coupe),context.getString(R.string.fiat_coupe_s),context.getString(R.string.fiat_coupe_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_linea),context.getString(R.string.fiat_linea_s),context.getString(R.string.fiat_linea_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_maria),context.getString(R.string.fiat_maria_s),context.getString(R.string.fiat_maria_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_mulipla),context.getString(R.string.fiat_mulipla_s),context.getString(R.string.fiat_mulipla_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_nuova_500),context.getString(R.string.fiat_nuova_500_s),context.getString(R.string.fiat_nuova_500_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_500c),context.getString(R.string.fiat_500c_s),context.getString(R.string.fiat_500c_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_750),context.getString(R.string.fiat_750_s),context.getString(R.string.fiat_750_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.fiat_other),context.getString(R.string.fiat_other_s),context.getString(R.string.fiat_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.ferrari)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_208),context.getString(R.string.ferrari_208_s),context.getString(R.string.ferrari_208_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_308),context.getString(R.string.ferrari_308_s),context.getString(R.string.ferrari_308_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_328),context.getString(R.string.ferrari_328_s),context.getString(R.string.ferrari_328_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_348),context.getString(R.string.ferrari_348_s),context.getString(R.string.ferrari_348_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_355),context.getString(R.string.ferrari_355_s),context.getString(R.string.ferrari_355_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_360_spider),context.getString(R.string.ferrari_360_spider_s),context.getString(R.string.ferrari_360_spider_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_360_modena),context.getString(R.string.ferrari_360_modena_s),context.getString(R.string.ferrari_360_modena_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_412),context.getString(R.string.ferrari_412_s),context.getString(R.string.ferrari_412_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_430),context.getString(R.string.ferrari_430_s),context.getString(R.string.ferrari_430_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_456_gt),context.getString(R.string.ferrari_456_gt_s),context.getString(R.string.ferrari_456_gt_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_458_italia),context.getString(R.string.ferrari_458_italia_s),context.getString(R.string.ferrari_458_italia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_512),context.getString(R.string.ferrari_512_s),context.getString(R.string.ferrari_512_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_550_barchetta),context.getString(R.string.ferrari_550_barchetta_s),context.getString(R.string.ferrari_550_barchetta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_550_maranello),context.getString(R.string.ferrari_550_maranello_s),context.getString(R.string.ferrari_550_maranello_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_575_maranello),context.getString(R.string.ferrari_575_maranello_s),context.getString(R.string.ferrari_575_maranello_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_599_gtb_Fiorano),context.getString(R.string.ferrari_599_gtb_Fiorano_s),context.getString(R.string.ferrari_599_gtb_Fiorano_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_612_scaglietti),context.getString(R.string.ferrari_612_scaglietti_s),context.getString(R.string.ferrari_612_scaglietti_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f340),context.getString(R.string.ferrari_f340_s),context.getString(R.string.ferrari_f340_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f355),context.getString(R.string.ferrari_f355_s),context.getString(R.string.ferrari_f355_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f40),context.getString(R.string.ferrari_f40_s),context.getString(R.string.ferrari_f40_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f430_scuderia),context.getString(R.string.ferrari_f430_scuderia_s),context.getString(R.string.ferrari_f430_scuderia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f430_spider),context.getString(R.string.ferrari_f430_spider_s),context.getString(R.string.ferrari_f430_spider_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f50),context.getString(R.string.ferrari_f50_s),context.getString(R.string.ferrari_f50_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_fxx),context.getString(R.string.ferrari_fxx_s),context.getString(R.string.ferrari_fxx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_enzo),context.getString(R.string.ferrari_enzo_s),context.getString(R.string.ferrari_enzo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_testarossa),context.getString(R.string.ferrari_testarossa_s),context.getString(R.string.ferrari_testarossa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_dino),context.getString(R.string.ferrari_dino_s),context.getString(R.string.ferrari_dino_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_california),context.getString(R.string.ferrari_california_s),context.getString(R.string.ferrari_california_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_laferrari),context.getString(R.string.ferrari_laferrari_s),context.getString(R.string.ferrari_laferrari_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_mondial),context.getString(R.string.ferrari_mondial_s),context.getString(R.string.ferrari_mondial_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_246),context.getString(R.string.ferrari_246_s),context.getString(R.string.ferrari_246_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_250),context.getString(R.string.ferrari_250_s),context.getString(R.string.ferrari_250_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_330),context.getString(R.string.ferrari_330_s),context.getString(R.string.ferrari_330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_360),context.getString(R.string.ferrari_360_s),context.getString(R.string.ferrari_360_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_365),context.getString(R.string.ferrari_365_s),context.getString(R.string.ferrari_365_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_456),context.getString(R.string.ferrari_456_s),context.getString(R.string.ferrari_456_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_488),context.getString(R.string.ferrari_488_s),context.getString(R.string.ferrari_488_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_575),context.getString(R.string.ferrari_575_s),context.getString(R.string.ferrari_575_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_599_gtb),context.getString(R.string.ferrari_599_gtb_s),context.getString(R.string.ferrari_599_gtb_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f12),context.getString(R.string.ferrari_f12_s),context.getString(R.string.ferrari_f12_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_f430),context.getString(R.string.ferrari_f430_s),context.getString(R.string.ferrari_f430_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_ff),context.getString(R.string.ferrari_ff_s),context.getString(R.string.ferrari_ff_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.ferrari_other),context.getString(R.string.ferrari_other_s),context.getString(R.string.ferrari_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.cadillac)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_ats),context.getString(R.string.cadillac_ats_s),context.getString(R.string.cadillac_ats_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_bls),context.getString(R.string.cadillac_bls_s),context.getString(R.string.cadillac_bls_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_ctc),context.getString(R.string.cadillac_ctc_s),context.getString(R.string.cadillac_ctc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_dts),context.getString(R.string.cadillac_dts_s),context.getString(R.string.cadillac_dts_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_deVille),context.getString(R.string.cadillac_deVille_s),context.getString(R.string.cadillac_deVille_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_elr),context.getString(R.string.cadillac_elr_s),context.getString(R.string.cadillac_elr_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_srx),context.getString(R.string.cadillac_srx_s),context.getString(R.string.cadillac_srx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_sts),context.getString(R.string.cadillac_sts_s),context.getString(R.string.cadillac_sts_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_xlr),context.getString(R.string.cadillac_xlr_s),context.getString(R.string.cadillac_xlr_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_escalade),context.getString(R.string.cadillac_escalade_s),context.getString(R.string.cadillac_escalade_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_allante),context.getString(R.string.cadillac_allante_s),context.getString(R.string.cadillac_allante_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_eldorado),context.getString(R.string.cadillac_eldorado_s),context.getString(R.string.cadillac_eldorado_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_brougham),context.getString(R.string.cadillac_brougham_s),context.getString(R.string.cadillac_brougham_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_seville),context.getString(R.string.cadillac_seville_s),context.getString(R.string.cadillac_seville_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_fleetwood),context.getString(R.string.cadillac_fleetwood_s),context.getString(R.string.cadillac_fleetwood_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_catera),context.getString(R.string.cadillac_catera_s),context.getString(R.string.cadillac_catera_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_coupe_deville),context.getString(R.string.cadillac_coupe_deville_s),context.getString(R.string.cadillac_coupe_deville_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_xts),context.getString(R.string.cadillac_xts_s),context.getString(R.string.cadillac_xts_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.cadillac_other),context.getString(R.string.cadillac_other_s),context.getString(R.string.cadillac_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.chrysler)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_200),context.getString(R.string.chrysler_200_s),context.getString(R.string.chrysler_200_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_300c),context.getString(R.string.chrysler_300c_s),context.getString(R.string.chrysler_300c_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_300m),context.getString(R.string.chrysler_300m_s),context.getString(R.string.chrysler_300m_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_lhs),context.getString(R.string.chrysler_lhs_s),context.getString(R.string.chrysler_lhs_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_aspen),context.getString(R.string.chrysler_aspen_s),context.getString(R.string.chrysler_aspen_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_imperial),context.getString(R.string.chrysler_imperial_s),context.getString(R.string.chrysler_imperial_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_intrepid),context.getString(R.string.chrysler_intrepid_s),context.getString(R.string.chrysler_intrepid_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_pasifica),context.getString(R.string.chrysler_pasifica_s),context.getString(R.string.chrysler_pasifica_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_prowler),context.getString(R.string.chrysler_prowler_s),context.getString(R.string.chrysler_prowler_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_pt_cruiser),context.getString(R.string.chrysler_pt_cruiser_s),context.getString(R.string.chrysler_pt_cruiser_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_town_country),context.getString(R.string.chrysler_town_country_s),context.getString(R.string.chrysler_town_country_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_grandvoyager),context.getString(R.string.chrysler_grandvoyager_s),context.getString(R.string.chrysler_grandvoyager_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_daytona_shelby),context.getString(R.string.chrysler_daytona_shelby_s),context.getString(R.string.chrysler_daytona_shelby_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_saratoga),context.getString(R.string.chrysler_saratoga_s),context.getString(R.string.chrysler_saratoga_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_sebring),context.getString(R.string.chrysler_sebring_s),context.getString(R.string.chrysler_sebring_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_cirrus),context.getString(R.string.chrysler_cirrus_s),context.getString(R.string.chrysler_cirrus_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_voyager),context.getString(R.string.chrysler_voyager_s),context.getString(R.string.chrysler_voyager_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_vision),context.getString(R.string.chrysler_vision_s),context.getString(R.string.chrysler_vision_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_fifth_avenue),context.getString(R.string.chrysler_fifth_avenue_s),context.getString(R.string.chrysler_fifth_avenue_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_crossfire),context.getString(R.string.chrysler_crossfire_s),context.getString(R.string.chrysler_crossfire_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_concorde),context.getString(R.string.chrysler_concorde_s),context.getString(R.string.chrysler_concorde_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_leBaron),context.getString(R.string.chrysler_leBaron_s),context.getString(R.string.chrysler_leBaron_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_nassau),context.getString(R.string.chrysler_nassau_s),context.getString(R.string.chrysler_nassau_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_neon),context.getString(R.string.chrysler_neon_s),context.getString(R.string.chrysler_neon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_new_yorker),context.getString(R.string.chrysler_new_yorker_s),context.getString(R.string.chrysler_new_yorker_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_300),context.getString(R.string.chrysler_300_s),context.getString(R.string.chrysler_300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_300s),context.getString(R.string.chrysler_300s_s),context.getString(R.string.chrysler_300s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.chrysler_other),context.getString(R.string.chrysler_other_s),context.getString(R.string.chrysler_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.lada)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_2010),context.getString(R.string.lada_2010_s),context.getString(R.string.lada_2010_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_2015),context.getString(R.string.lada_2015_s),context.getString(R.string.lada_2015_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_2107),context.getString(R.string.lada_2107_s),context.getString(R.string.lada_2107_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_2170),context.getString(R.string.lada_2170_s),context.getString(R.string.lada_2170_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_aleko),context.getString(R.string.lada_aleko_s),context.getString(R.string.lada_aleko_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_oka),context.getString(R.string.lada_oka_s),context.getString(R.string.lada_oka_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_samara),context.getString(R.string.lada_samara_s),context.getString(R.string.lada_samara_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_niva),context.getString(R.string.lada_niva_s),context.getString(R.string.lada_niva_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_vesta),context.getString(R.string.lada_vesta_s),context.getString(R.string.lada_vesta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_vesta_sw),context.getString(R.string.lada_vesta_sw_s),context.getString(R.string.lada_vesta_sw_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_granta),context.getString(R.string.lada_granta_s),context.getString(R.string.lada_granta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_Granta_hb),context.getString(R.string.lada_Granta_hb_s),context.getString(R.string.lada_Granta_hb_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_largus),context.getString(R.string.lada_largus_s),context.getString(R.string.lada_largus_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_4x4_urban),context.getString(R.string.lada_4x4_urban_s),context.getString(R.string.lada_4x4_urban_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lada_other),context.getString(R.string.lada_other_s),context.getString(R.string.lada_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.lamborghini)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_lm002),context.getString(R.string.lamborghini_lm002_s),context.getString(R.string.lamborghini_lm002_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_aventador),context.getString(R.string.lamborghini_aventador_s),context.getString(R.string.lamborghini_aventador_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_espada),context.getString(R.string.lamborghini_espada_s),context.getString(R.string.lamborghini_espada_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_jalpa),context.getString(R.string.lamborghini_jalpa_s),context.getString(R.string.lamborghini_jalpa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_diablo),context.getString(R.string.lamborghini_diablo_s),context.getString(R.string.lamborghini_diablo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_reventon),context.getString(R.string.lamborghini_reventon_s),context.getString(R.string.lamborghini_reventon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_gallardo),context.getString(R.string.lamborghini_gallardo_s),context.getString(R.string.lamborghini_gallardo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_countach),context.getString(R.string.lamborghini_countach_s),context.getString(R.string.lamborghini_countach_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_murcielago),context.getString(R.string.lamborghini_murcielago_s),context.getString(R.string.lamborghini_murcielago_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_huracan),context.getString(R.string.lamborghini_huracan_s),context.getString(R.string.lamborghini_huracan_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_350gt),context.getString(R.string.lamborghini_350gt_s),context.getString(R.string.lamborghini_350gt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lamborghini_other),context.getString(R.string.lamborghini_other_s),context.getString(R.string.lamborghini_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.land_rover)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_lr4),context.getString(R.string.land_rover_lr4_s),context.getString(R.string.land_rover_lr4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_discovery),context.getString(R.string.land_rover_discovery_s),context.getString(R.string.land_rover_discovery_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_discovery_sport),context.getString(R.string.land_rover_discovery_sport_s),context.getString(R.string.land_rover_discovery_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_defender),context.getString(R.string.land_rover_defender_s),context.getString(R.string.land_rover_defender_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_hse),context.getString(R.string.land_rover_range_rover_hse_s),context.getString(R.string.land_rover_range_rover_hse_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_evoque),context.getString(R.string.land_rover_range_rover_evoque_s),context.getString(R.string.land_rover_range_rover_evoque_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_sport),context.getString(R.string.land_rover_range_rover_sport_s),context.getString(R.string.land_rover_range_rover_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_vogue),context.getString(R.string.land_rover_range_rover_vogue_s),context.getString(R.string.land_rover_range_rover_vogue_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover_velar),context.getString(R.string.land_rover_range_rover_velar_s),context.getString(R.string.land_rover_range_rover_velar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_range_rover),context.getString(R.string.land_rover_range_rover_s),context.getString(R.string.land_rover_range_rover_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_freelander),context.getString(R.string.land_rover_freelander_s),context.getString(R.string.land_rover_freelander_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.land_rover_other),context.getString(R.string.land_rover_other_s),context.getString(R.string.land_rover_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.lexus)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_e_s),context.getString(R.string.lexus_e_s_s),context.getString(R.string.lexus_e_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_es),context.getString(R.string.lexus_es_s),context.getString(R.string.lexus_es_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_es_250),context.getString(R.string.lexus_es_250_s),context.getString(R.string.lexus_es_250_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_es_300),context.getString(R.string.lexus_es_300_s),context.getString(R.string.lexus_es_300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_es_330),context.getString(R.string.lexus_es_330_s),context.getString(R.string.lexus_es_330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_es_350),context.getString(R.string.lexus_es_350_s),context.getString(R.string.lexus_es_350_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_g_s),context.getString(R.string.lexus_g_s_s),context.getString(R.string.lexus_g_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gs_250),context.getString(R.string.lexus_gs_250_s),context.getString(R.string.lexus_gs_250_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gs_300),context.getString(R.string.lexus_gs_300_s),context.getString(R.string.lexus_gs_300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gs_350),context.getString(R.string.lexus_gs_350_s),context.getString(R.string.lexus_gs_350_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gs_400),context.getString(R.string.lexus_gs_400_s),context.getString(R.string.lexus_gs_400_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gs_430),context.getString(R.string.lexus_gs_430_s),context.getString(R.string.lexus_gs_430_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gs_460),context.getString(R.string.lexus_gs_460_s),context.getString(R.string.lexus_gs_460_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gx),context.getString(R.string.lexus_gx_s),context.getString(R.string.lexus_gx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gx_460),context.getString(R.string.lexus_gx_460_s),context.getString(R.string.lexus_gx_460_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_gx_470),context.getString(R.string.lexus_gx_470_s),context.getString(R.string.lexus_gx_470_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_is),context.getString(R.string.lexus_is_s),context.getString(R.string.lexus_is_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_is_200),context.getString(R.string.lexus_is_200_s),context.getString(R.string.lexus_is_200_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_is_250),context.getString(R.string.lexus_is_250_s),context.getString(R.string.lexus_is_250_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_is_300),context.getString(R.string.lexus_is_300_s),context.getString(R.string.lexus_is_300_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_is_350),context.getString(R.string.lexus_is_350_s),context.getString(R.string.lexus_is_350_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_ls),context.getString(R.string.lexus_ls_s),context.getString(R.string.lexus_ls_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_ls_400),context.getString(R.string.lexus_ls_400_s),context.getString(R.string.lexus_ls_400_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_ls_430),context.getString(R.string.lexus_ls_430_s),context.getString(R.string.lexus_ls_430_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_ls_460),context.getString(R.string.lexus_ls_460_s),context.getString(R.string.lexus_ls_460_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_ls_600),context.getString(R.string.lexus_ls_600_s),context.getString(R.string.lexus_ls_600_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_lx),context.getString(R.string.lexus_lx_s),context.getString(R.string.lexus_lx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_LX_450),context.getString(R.string.lexus_LX_450_s),context.getString(R.string.lexus_LX_450_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_LX_470),context.getString(R.string.lexus_LX_470_s),context.getString(R.string.lexus_LX_470_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_LX_570),context.getString(R.string.lexus_LX_570_s),context.getString(R.string.lexus_LX_570_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_nx),context.getString(R.string.lexus_nx_s),context.getString(R.string.lexus_nx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_nx_200t),context.getString(R.string.lexus_nx_200t_s),context.getString(R.string.lexus_nx_200t_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_nx_300),context.getString(R.string.lexus_nx_300_s),context.getString(R.string.lexus_nx_300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_rc),context.getString(R.string.lexus_rc_s),context.getString(R.string.lexus_rc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_rc_350),context.getString(R.string.lexus_rc_350_s),context.getString(R.string.lexus_rc_350_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_rc_f),context.getString(R.string.lexus_rc_f_s),context.getString(R.string.lexus_rc_f_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_rx),context.getString(R.string.lexus_rx_s),context.getString(R.string.lexus_rx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_rx_300),context.getString(R.string.lexus_rx_300_s),context.getString(R.string.lexus_rx_300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_rx_330),context.getString(R.string.lexus_rx_330_s),context.getString(R.string.lexus_rx_330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_rx_350),context.getString(R.string.lexus_rx_350_s),context.getString(R.string.lexus_rx_350_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_xr_450),context.getString(R.string.lexus_xr_450_s),context.getString(R.string.lexus_xr_450_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_sc),context.getString(R.string.lexus_sc_s),context.getString(R.string.lexus_sc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_sc_300),context.getString(R.string.lexus_sc_300_s),context.getString(R.string.lexus_sc_300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_sc_430),context.getString(R.string.lexus_sc_430_s),context.getString(R.string.lexus_sc_430_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_ct),context.getString(R.string.lexus_ct_s),context.getString(R.string.lexus_ct_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_hs),context.getString(R.string.lexus_hs_s),context.getString(R.string.lexus_hs_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_isf),context.getString(R.string.lexus_isf_s),context.getString(R.string.lexus_isf_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_lfa),context.getString(R.string.lexus_lfa_s),context.getString(R.string.lexus_lfa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_ux),context.getString(R.string.lexus_ux_s),context.getString(R.string.lexus_ux_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lexus_other),context.getString(R.string.lexus_other_s),context.getString(R.string.lexus_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.lotus)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_esprit),context.getString(R.string.lotus_esprit_s),context.getString(R.string.lotus_esprit_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_elite),context.getString(R.string.lotus_elite_s),context.getString(R.string.lotus_elite_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_elise),context.getString(R.string.lotus_elise_s),context.getString(R.string.lotus_elise_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_eclat),context.getString(R.string.lotus_eclat_s),context.getString(R.string.lotus_eclat_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_evora),context.getString(R.string.lotus_evora_s),context.getString(R.string.lotus_evora_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_excel),context.getString(R.string.lotus_excel_s),context.getString(R.string.lotus_excel_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_exige),context.getString(R.string.lotus_exige_s),context.getString(R.string.lotus_exige_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_elan),context.getString(R.string.lotus_elan_s),context.getString(R.string.lotus_elan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_yoruba),context.getString(R.string.lotus_yoruba_s),context.getString(R.string.lotus_yoruba_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lotus_other),context.getString(R.string.lotus_other_s),context.getString(R.string.lotus_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.lincoln)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_mkx),context.getString(R.string.lincoln_mkx_s),context.getString(R.string.lincoln_mkx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_mkz),context.getString(R.string.lincoln_mkz_s),context.getString(R.string.lincoln_mkz_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_mark_lt),context.getString(R.string.lincoln_mark_lt_s),context.getString(R.string.lincoln_mark_lt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_aviator),context.getString(R.string.lincoln_aviator_s),context.getString(R.string.lincoln_aviator_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_blackwood),context.getString(R.string.lincoln_blackwood_s),context.getString(R.string.lincoln_blackwood_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_town_car),context.getString(R.string.lincoln_town_car_s),context.getString(R.string.lincoln_town_car_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_zephyr),context.getString(R.string.lincoln_zephyr_s),context.getString(R.string.lincoln_zephyr_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_continental),context.getString(R.string.lincoln_continental_s),context.getString(R.string.lincoln_continental_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_mark),context.getString(R.string.lincoln_mark_s),context.getString(R.string.lincoln_mark_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_navigator),context.getString(R.string.lincoln_navigator_s),context.getString(R.string.lincoln_navigator_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_capri),context.getString(R.string.lincoln_capri_s),context.getString(R.string.lincoln_capri_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_mks),context.getString(R.string.lincoln_mks_s),context.getString(R.string.lincoln_mks_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lincoln_other),context.getString(R.string.lincoln_other_s),context.getString(R.string.lincoln_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.mazda)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_2),context.getString(R.string.mazda_2_s),context.getString(R.string.mazda_2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_3),context.getString(R.string.mazda_3_s),context.getString(R.string.mazda_3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_5),context.getString(R.string.mazda_5_s),context.getString(R.string.mazda_5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_121),context.getString(R.string.mazda_121_s),context.getString(R.string.mazda_121_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_323),context.getString(R.string.mazda_323_s),context.getString(R.string.mazda_323_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_818),context.getString(R.string.mazda_818_s),context.getString(R.string.mazda_818_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_929),context.getString(R.string.mazda_929_s),context.getString(R.string.mazda_929_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_1000),context.getString(R.string.mazda_1000_s),context.getString(R.string.mazda_1000_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_1300),context.getString(R.string.mazda_1300_s),context.getString(R.string.mazda_1300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_3_mps),context.getString(R.string.mazda_3_mps_s),context.getString(R.string.mazda_3_mps_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_6_mps),context.getString(R.string.mazda_6_mps_s),context.getString(R.string.mazda_6_mps_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_bt_50),context.getString(R.string.mazda_bt_50_s),context.getString(R.string.mazda_bt_50_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_cx_5),context.getString(R.string.mazda_cx_5_s),context.getString(R.string.mazda_cx_5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_cx_7),context.getString(R.string.mazda_cx_7_s),context.getString(R.string.mazda_cx_7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_cx_9),context.getString(R.string.mazda_cx_9_s),context.getString(R.string.mazda_cx_9_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_mpv),context.getString(R.string.mazda_mpv_s),context.getString(R.string.mazda_mpv_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_mx_3),context.getString(R.string.mazda_mx_3_s),context.getString(R.string.mazda_mx_3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_mx_5),context.getString(R.string.mazda_mx_5_s),context.getString(R.string.mazda_mx_5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_rx7),context.getString(R.string.mazda_rx7_s),context.getString(R.string.mazda_rx7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_rx8),context.getString(R.string.mazda_rx8_s),context.getString(R.string.mazda_rx8_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_6),context.getString(R.string.mazda_6_s),context.getString(R.string.mazda_6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_efini),context.getString(R.string.mazda_efini_s),context.getString(R.string.mazda_efini_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_proceed),context.getString(R.string.mazda_proceed_s),context.getString(R.string.mazda_proceed_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_premacy),context.getString(R.string.mazda_premacy_s),context.getString(R.string.mazda_premacy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_bongo),context.getString(R.string.mazda_bongo_s),context.getString(R.string.mazda_bongo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_binte),context.getString(R.string.mazda_binte_s),context.getString(R.string.mazda_binte_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_pickup),context.getString(R.string.mazda_pickup_s),context.getString(R.string.mazda_pickup_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_tribute),context.getString(R.string.mazda_tribute_s),context.getString(R.string.mazda_tribute_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_demio),context.getString(R.string.mazda_demio_s),context.getString(R.string.mazda_demio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_rustler),context.getString(R.string.mazda_rustler_s),context.getString(R.string.mazda_rustler_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_spiano),context.getString(R.string.mazda_spiano_s),context.getString(R.string.mazda_spiano_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_scrumm),context.getString(R.string.mazda_scrumm_s),context.getString(R.string.mazda_scrumm_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_zedos_6),context.getString(R.string.mazda_zedos_6_s),context.getString(R.string.mazda_zedos_6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_zedos_9),context.getString(R.string.mazda_zedos_9_s),context.getString(R.string.mazda_zedos_9_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_sentia),context.getString(R.string.mazda_sentia_s),context.getString(R.string.mazda_sentia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_fmilia),context.getString(R.string.mazda_fmilia_s),context.getString(R.string.mazda_fmilia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_vantrend),context.getString(R.string.mazda_vantrend_s),context.getString(R.string.mazda_vantrend_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_capella),context.getString(R.string.mazda_capella_s),context.getString(R.string.mazda_capella_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_carol),context.getString(R.string.mazda_carol_s),context.getString(R.string.mazda_carol_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_cliff),context.getString(R.string.mazda_cliff_s),context.getString(R.string.mazda_cliff_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_laputa),context.getString(R.string.mazda_laputa_s),context.getString(R.string.mazda_laputa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_lantis),context.getString(R.string.mazda_lantis_s),context.getString(R.string.mazda_lantis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_levante),context.getString(R.string.mazda_levante_s),context.getString(R.string.mazda_levante_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_luce),context.getString(R.string.mazda_luce_s),context.getString(R.string.mazda_luce_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_cx_30),context.getString(R.string.mazda_cx_30_s),context.getString(R.string.mazda_cx_30_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_Tttan),context.getString(R.string.mazda_Tttan_s),context.getString(R.string.mazda_Tttan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mazda_other),context.getString(R.string.mazda_other_s),context.getString(R.string.mazda_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.maserati)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_228),context.getString(R.string.maserati_228_s),context.getString(R.string.maserati_228_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_gt3200),context.getString(R.string.maserati_gt3200_s),context.getString(R.string.maserati_gt3200_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_mc12),context.getString(R.string.maserati_mc12_s),context.getString(R.string.maserati_mc12_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_indy),context.getString(R.string.maserati_indy_s),context.getString(R.string.maserati_indy_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_barchetta_stradale),context.getString(R.string.maserati_barchetta_stradale_s),context.getString(R.string.maserati_barchetta_stradale_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_bora),context.getString(R.string.maserati_bora_s),context.getString(R.string.maserati_bora_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_biturbo),context.getString(R.string.maserati_biturbo_s),context.getString(R.string.maserati_biturbo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_chubasco),context.getString(R.string.maserati_chubasco_s),context.getString(R.string.maserati_chubasco_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_ghibli),context.getString(R.string.maserati_ghibli_s),context.getString(R.string.maserati_ghibli_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_khamsin),context.getString(R.string.maserati_khamsin_s),context.getString(R.string.maserati_khamsin_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_royale),context.getString(R.string.maserati_royale_s),context.getString(R.string.maserati_royale_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_spyder),context.getString(R.string.maserati_spyder_s),context.getString(R.string.maserati_spyder_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_shamal),context.getString(R.string.maserati_shamal_s),context.getString(R.string.maserati_shamal_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_granTurismo),context.getString(R.string.maserati_granTurismo_s),context.getString(R.string.maserati_granTurismo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_granSport),context.getString(R.string.maserati_granSport_s),context.getString(R.string.maserati_granSport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_granCabrio),context.getString(R.string.maserati_granCabrio_s),context.getString(R.string.maserati_granCabrio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_karif),context.getString(R.string.maserati_karif_s),context.getString(R.string.maserati_karif_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_quattroporte),context.getString(R.string.maserati_quattroporte_s),context.getString(R.string.maserati_quattroporte_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_coupe),context.getString(R.string.maserati_coupe_s),context.getString(R.string.maserati_coupe_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_kyalami),context.getString(R.string.maserati_kyalami_s),context.getString(R.string.maserati_kyalami_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_maxico),context.getString(R.string.maserati_maxico_s),context.getString(R.string.maserati_maxico_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_merak),context.getString(R.string.maserati_merak_s),context.getString(R.string.maserati_merak_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maserati_other),context.getString(R.string.maserati_other_s),context.getString(R.string.maserati_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.morgan)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.morgan_plus4),context.getString(R.string.morgan_plus4_s),context.getString(R.string.morgan_plus4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.morgan_plus8),context.getString(R.string.morgan_plus8_s),context.getString(R.string.morgan_plus8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.morgan_v6),context.getString(R.string.morgan_v6_s),context.getString(R.string.morgan_v6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.morgan_aero),context.getString(R.string.morgan_aero_s),context.getString(R.string.morgan_aero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.morgan_aero_8),context.getString(R.string.morgan_aero_8_s),context.getString(R.string.morgan_aero_8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.morgan_roadster),context.getString(R.string.morgan_roadster_s),context.getString(R.string.morgan_roadster_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.morgan_other),context.getString(R.string.morgan_other_s),context.getString(R.string.morgan_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.mitsubishi)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_asx),context.getString(R.string.mitsubishi_asx_s),context.getString(R.string.mitsubishi_asx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_fto),context.getString(R.string.mitsubishi_fto_s),context.getString(R.string.mitsubishi_fto_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_3000gt),context.getString(R.string.mitsubishi_3000gt_s),context.getString(R.string.mitsubishi_3000gt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_gto),context.getString(R.string.mitsubishi_gto_s),context.getString(R.string.mitsubishi_gto_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_l200),context.getString(R.string.mitsubishi_l200_s),context.getString(R.string.mitsubishi_l200_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_rvr),context.getString(R.string.mitsubishi_rvr_s),context.getString(R.string.mitsubishi_rvr_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_outlander),context.getString(R.string.mitsubishi_outlander_s),context.getString(R.string.mitsubishi_outlander_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_aspire),context.getString(R.string.mitsubishi_aspire_s),context.getString(R.string.mitsubishi_aspire_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_eclipse),context.getString(R.string.mitsubishi_eclipse_s),context.getString(R.string.mitsubishi_eclipse_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_endeavour),context.getString(R.string.mitsubishi_endeavour_s),context.getString(R.string.mitsubishi_endeavour_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_i_miev),context.getString(R.string.mitsubishi_i_miev_s),context.getString(R.string.mitsubishi_i_miev_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_evolution),context.getString(R.string.mitsubishi_evolution_s),context.getString(R.string.mitsubishi_evolution_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_eK_wagon),context.getString(R.string.mitsubishi_eK_wagon_s),context.getString(R.string.mitsubishi_eK_wagon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_emeraude),context.getString(R.string.mitsubishi_emeraude_s),context.getString(R.string.mitsubishi_emeraude_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_pajero),context.getString(R.string.mitsubishi_pajero_s),context.getString(R.string.mitsubishi_pajero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_pajero_sport),context.getString(R.string.mitsubishi_pajero_sport_s),context.getString(R.string.mitsubishi_pajero_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_proudia),context.getString(R.string.mitsubishi_proudia_s),context.getString(R.string.mitsubishi_proudia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_pistachio),context.getString(R.string.mitsubishi_pistachio_s),context.getString(R.string.mitsubishi_pistachio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_town_box),context.getString(R.string.mitsubishi_town_box_s),context.getString(R.string.mitsubishi_town_box_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_tredia),context.getString(R.string.mitsubishi_tredia_s),context.getString(R.string.mitsubishi_tredia_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_chariot),context.getString(R.string.mitsubishi_chariot_s),context.getString(R.string.mitsubishi_chariot_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_galant),context.getString(R.string.mitsubishi_galant_s),context.getString(R.string.mitsubishi_galant_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_grandis),context.getString(R.string.mitsubishi_grandis_s),context.getString(R.string.mitsubishi_grandis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_jeep),context.getString(R.string.mitsubishi_jeep_s),context.getString(R.string.mitsubishi_jeep_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_debonair),context.getString(R.string.mitsubishi_debonair_s),context.getString(R.string.mitsubishi_debonair_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_delica),context.getString(R.string.mitsubishi_delica_s),context.getString(R.string.mitsubishi_delica_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_dingo),context.getString(R.string.mitsubishi_dingo_s),context.getString(R.string.mitsubishi_dingo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_dion),context.getString(R.string.mitsubishi_dion_s),context.getString(R.string.mitsubishi_dion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_raider),context.getString(R.string.mitsubishi_raider_s),context.getString(R.string.mitsubishi_raider_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_sapporo),context.getString(R.string.mitsubishi_sapporo_s),context.getString(R.string.mitsubishi_sapporo_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_space_runner),context.getString(R.string.mitsubishi_space_runner_s),context.getString(R.string.mitsubishi_space_runner_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_space_star),context.getString(R.string.mitsubishi_space_star_s),context.getString(R.string.mitsubishi_space_star_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_space_wagon),context.getString(R.string.mitsubishi_space_wagon_s),context.getString(R.string.mitsubishi_space_wagon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_celeste),context.getString(R.string.mitsubishi_celeste_s),context.getString(R.string.mitsubishi_celeste_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_fuso_canter),context.getString(R.string.mitsubishi_fuso_canter_s),context.getString(R.string.mitsubishi_fuso_canter_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_fuso_rosa),context.getString(R.string.mitsubishi_fuso_rosa_s),context.getString(R.string.mitsubishi_fuso_rosa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_carisma),context.getString(R.string.mitsubishi_carisma_s),context.getString(R.string.mitsubishi_carisma_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_canter),context.getString(R.string.mitsubishi_canter_s),context.getString(R.string.mitsubishi_canter_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_cordia),context.getString(R.string.mitsubishi_cordia_s),context.getString(R.string.mitsubishi_cordia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_colt),context.getString(R.string.mitsubishi_colt_s),context.getString(R.string.mitsubishi_colt_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_lancer),context.getString(R.string.mitsubishi_lancer_s),context.getString(R.string.mitsubishi_lancer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_legnum),context.getString(R.string.mitsubishi_legnum_s),context.getString(R.string.mitsubishi_legnum_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_magna),context.getString(R.string.mitsubishi_magna_s),context.getString(R.string.mitsubishi_magna_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_montero),context.getString(R.string.mitsubishi_montero_s),context.getString(R.string.mitsubishi_montero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_mirage),context.getString(R.string.mitsubishi_mirage_s),context.getString(R.string.mitsubishi_mirage_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_monica),context.getString(R.string.mitsubishi_monica_s),context.getString(R.string.mitsubishi_monica_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_native),context.getString(R.string.mitsubishi_native_s),context.getString(R.string.mitsubishi_native_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_attrage),context.getString(R.string.mitsubishi_attrage_s),context.getString(R.string.mitsubishi_attrage_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_fuso),context.getString(R.string.mitsubishi_fuso_s),context.getString(R.string.mitsubishi_fuso_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_pajero_io),context.getString(R.string.mitsubishi_pajero_io_s),context.getString(R.string.mitsubishi_pajero_io_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_pajero_mini),context.getString(R.string.mitsubishi_pajero_mini_s),context.getString(R.string.mitsubishi_pajero_mini_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_rosa),context.getString(R.string.mitsubishi_rosa_s),context.getString(R.string.mitsubishi_rosa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mitsubishi_other),context.getString(R.string.mitsubishi_other_s),context.getString(R.string.mitsubishi_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.mercury)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_tracer),context.getString(R.string.mercury_tracer_s),context.getString(R.string.mercury_tracer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_topaz),context.getString(R.string.mercury_topaz_s),context.getString(R.string.mercury_topaz_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_grand_marquis),context.getString(R.string.mercury_grand_marquis_s),context.getString(R.string.mercury_grand_marquis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_sable),context.getString(R.string.mercury_sable_s),context.getString(R.string.mercury_sable_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_villager),context.getString(R.string.mercury_villager_s),context.getString(R.string.mercury_villager_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_capri),context.getString(R.string.mercury_capri_s),context.getString(R.string.mercury_capri_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_cougar),context.getString(R.string.mercury_cougar_s),context.getString(R.string.mercury_cougar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_marauder),context.getString(R.string.mercury_marauder_s),context.getString(R.string.mercury_marauder_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_marquis),context.getString(R.string.mercury_marquis_s),context.getString(R.string.mercury_marquis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_mariner),context.getString(R.string.mercury_mariner_s),context.getString(R.string.mercury_mariner_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_mountaineer),context.getString(R.string.mercury_mountaineer_s),context.getString(R.string.mercury_mountaineer_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_montego),context.getString(R.string.mercury_montego_s),context.getString(R.string.mercury_montego_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_mystique),context.getString(R.string.mercury_mystique_s),context.getString(R.string.mercury_mystique_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_milan),context.getString(R.string.mercury_milan_s),context.getString(R.string.mercury_milan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mercury_other),context.getString(R.string.mercury_other_s),context.getString(R.string.mercury_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.mini)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_one),context.getString(R.string.mini_one_s),context.getString(R.string.mini_one_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_clubman),context.getString(R.string.mini_clubman_s),context.getString(R.string.mini_clubman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper),context.getString(R.string.mini_cooper_s),context.getString(R.string.mini_cooper_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_countryman),context.getString(R.string.mini_countryman_s),context.getString(R.string.mini_countryman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_cabrio),context.getString(R.string.mini_cooper_cabrio_s),context.getString(R.string.mini_cooper_cabrio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_paceman),context.getString(R.string.mini_cooper_paceman_s),context.getString(R.string.mini_cooper_paceman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_s),context.getString(R.string.mini_cooper_s_s),context.getString(R.string.mini_cooper_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_s_cabrio),context.getString(R.string.mini_cooper_s_cabrio_s),context.getString(R.string.mini_cooper_s_cabrio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_s_clubman),context.getString(R.string.mini_cooper_s_clubman_s),context.getString(R.string.mini_cooper_s_clubman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_s_countryman),context.getString(R.string.mini_cooper_s_countryman_s),context.getString(R.string.mini_cooper_s_countryman_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_s_Coupé),context.getString(R.string.mini_cooper_s_Coupé_s),context.getString(R.string.mini_cooper_s_Coupé_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_cooper_s_paceman),context.getString(R.string.mini_cooper_s_paceman_s),context.getString(R.string.mini_cooper_s_paceman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_John_cooper_works),context.getString(R.string.mini_John_cooper_works_s),context.getString(R.string.mini_John_cooper_works_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_John_cooper_works_countryman),context.getString(R.string.mini_John_cooper_works_countryman_s),context.getString(R.string.mini_John_cooper_works_countryman_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_john_cooper_works_coupé),context.getString(R.string.mini_john_cooper_works_coupé_s),context.getString(R.string.mini_john_cooper_works_coupé_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mini_other),context.getString(R.string.mini_other_s),context.getString(R.string.mini_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.nissan)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_100nx),context.getString(R.string.nissan_100nx_s),context.getString(R.string.nissan_100nx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_180sx),context.getString(R.string.nissan_180sx_s),context.getString(R.string.nissan_180sx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_200sx),context.getString(R.string.nissan_200sx_s),context.getString(R.string.nissan_200sx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_240sx),context.getString(R.string.nissan_240sx_s),context.getString(R.string.nissan_240sx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_280zx),context.getString(R.string.nissan_280zx_s),context.getString(R.string.nissan_280zx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_300xz),context.getString(R.string.nissan_300xz_s),context.getString(R.string.nissan_300xz_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_350z),context.getString(R.string.nissan_350z_s),context.getString(R.string.nissan_350z_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_370z),context.getString(R.string.nissan_370z_s),context.getString(R.string.nissan_370z_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_ad),context.getString(R.string.nissan_ad_s),context.getString(R.string.nissan_ad_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_gt_r),context.getString(R.string.nissan_gt_r_s),context.getString(R.string.nissan_gt_r_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_np_300),context.getString(R.string.nissan_np_300_s),context.getString(R.string.nissan_np_300_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_nx_coupe),context.getString(R.string.nissan_nx_coupe_s),context.getString(R.string.nissan_nx_coupe_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_x_trail),context.getString(R.string.nissan_x_trail_s),context.getString(R.string.nissan_x_trail_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_elgrand),context.getString(R.string.nissan_elgrand_s),context.getString(R.string.nissan_elgrand_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_armada),context.getString(R.string.nissan_armada_s),context.getString(R.string.nissan_armada_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_avenir),context.getString(R.string.nissan_avenir_s),context.getString(R.string.nissan_avenir_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_xterra),context.getString(R.string.nissan_xterra_s),context.getString(R.string.nissan_xterra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_altima),context.getString(R.string.nissan_altima_s),context.getString(R.string.nissan_altima_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_almera),context.getString(R.string.nissan_almera_s),context.getString(R.string.nissan_almera_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_otti),context.getString(R.string.nissan_otti_s),context.getString(R.string.nissan_otti_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_patrol),context.getString(R.string.nissan_patrol_s),context.getString(R.string.nissan_patrol_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_pathfinder),context.getString(R.string.nissan_pathfinder_s),context.getString(R.string.nissan_pathfinder_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_bassara),context.getString(R.string.nissan_bassara_s),context.getString(R.string.nissan_bassara_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_prairie),context.getString(R.string.nissan_prairie_s),context.getString(R.string.nissan_prairie_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_presage),context.getString(R.string.nissan_presage_s),context.getString(R.string.nissan_presage_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_presea),context.getString(R.string.nissan_presea_s),context.getString(R.string.nissan_presea_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_president),context.getString(R.string.nissan_president_s),context.getString(R.string.nissan_president_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_bluebird),context.getString(R.string.nissan_bluebird_s),context.getString(R.string.nissan_bluebird_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_pulsar),context.getString(R.string.nissan_pulsar_s),context.getString(R.string.nissan_pulsar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_pickup),context.getString(R.string.nissan_pickup_s),context.getString(R.string.nissan_pickup_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_titan),context.getString(R.string.nissan_titan_s),context.getString(R.string.nissan_titan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_cherry),context.getString(R.string.nissan_cherry_s),context.getString(R.string.nissan_cherry_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_tiida),context.getString(R.string.nissan_tiida_s),context.getString(R.string.nissan_tiida_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_terrano),context.getString(R.string.nissan_terrano_s),context.getString(R.string.nissan_terrano_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_gloria),context.getString(R.string.nissan_gloria_s),context.getString(R.string.nissan_gloria_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_juke),context.getString(R.string.nissan_juke_s),context.getString(R.string.nissan_juke_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_junior),context.getString(R.string.nissan_junior_s),context.getString(R.string.nissan_junior_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_datsun),context.getString(R.string.nissan_datsun_s),context.getString(R.string.nissan_datsun_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_rasheen),context.getString(R.string.nissan_rasheen_s),context.getString(R.string.nissan_rasheen_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_rogue),context.getString(R.string.nissan_rogue_s),context.getString(R.string.nissan_rogue_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_stagea),context.getString(R.string.nissan_stagea_s),context.getString(R.string.nissan_stagea_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_stanza),context.getString(R.string.nissan_stanza_s),context.getString(R.string.nissan_stanza_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_skyline),context.getString(R.string.nissan_skyline_s),context.getString(R.string.nissan_skyline_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_sentra),context.getString(R.string.nissan_sentra_s),context.getString(R.string.nissan_sentra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_cadric),context.getString(R.string.nissan_cadric_s),context.getString(R.string.nissan_cadric_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_serena),context.getString(R.string.nissan_serena_s),context.getString(R.string.nissan_serena_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_cefiro),context.getString(R.string.nissan_cefiro_s),context.getString(R.string.nissan_cefiro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_silvia),context.getString(R.string.nissan_silvia_s),context.getString(R.string.nissan_silvia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_cima),context.getString(R.string.nissan_cima_s),context.getString(R.string.nissan_cima_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_sunny),context.getString(R.string.nissan_sunny_s),context.getString(R.string.nissan_sunny_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_van),context.getString(R.string.nissan_van_s),context.getString(R.string.nissan_van_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_vanette),context.getString(R.string.nissan_vanette_s),context.getString(R.string.nissan_vanette_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_fairlady),context.getString(R.string.nissan_fairlady_s),context.getString(R.string.nissan_fairlady_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_frontier),context.getString(R.string.nissan_frontier_s),context.getString(R.string.nissan_frontier_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_fuga),context.getString(R.string.nissan_fuga_s),context.getString(R.string.nissan_fuga_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_versa),context.getString(R.string.nissan_versa_s),context.getString(R.string.nissan_versa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_figaro),context.getString(R.string.nissan_figaro_s),context.getString(R.string.nissan_figaro_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_qashqai),context.getString(R.string.nissan_qashqai_s),context.getString(R.string.nissan_qashqai_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_crew),context.getString(R.string.nissan_crew_s),context.getString(R.string.nissan_crew_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_quest),context.getString(R.string.nissan_quest_s),context.getString(R.string.nissan_quest_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_kicks),context.getString(R.string.nissan_kicks_s),context.getString(R.string.nissan_kicks_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_cube),context.getString(R.string.nissan_cube_s),context.getString(R.string.nissan_cube_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_largo),context.getString(R.string.nissan_largo_s),context.getString(R.string.nissan_largo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_lafesta),context.getString(R.string.nissan_lafesta_s),context.getString(R.string.nissan_lafesta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_laurel),context.getString(R.string.nissan_laurel_s),context.getString(R.string.nissan_laurel_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_lucino),context.getString(R.string.nissan_lucino_s),context.getString(R.string.nissan_lucino_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_lberty),context.getString(R.string.nissan_lberty_s),context.getString(R.string.nissan_lberty_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_leaf),context.getString(R.string.nissan_leaf_s),context.getString(R.string.nissan_leaf_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_livina),context.getString(R.string.nissan_livina_s),context.getString(R.string.nissan_livina_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_leopard),context.getString(R.string.nissan_leopard_s),context.getString(R.string.nissan_leopard_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_maxima),context.getString(R.string.nissan_maxima_s),context.getString(R.string.nissan_maxima_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_murano),context.getString(R.string.nissan_murano_s),context.getString(R.string.nissan_murano_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_moco),context.getString(R.string.nissan_moco_s),context.getString(R.string.nissan_moco_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_mistral),context.getString(R.string.nissan_mistral_s),context.getString(R.string.nissan_mistral_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_micra),context.getString(R.string.nissan_micra_s),context.getString(R.string.nissan_micra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_navara),context.getString(R.string.nissan_navara_s),context.getString(R.string.nissan_navara_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_n90),context.getString(R.string.nissan_n90_s),context.getString(R.string.nissan_n90_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_wingroad),context.getString(R.string.nissan_wingroad_s),context.getString(R.string.nissan_wingroad_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_almera_tino),context.getString(R.string.nissan_almera_tino_s),context.getString(R.string.nissan_almera_tino_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_caravan),context.getString(R.string.nissan_caravan_s),context.getString(R.string.nissan_caravan_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_condor),context.getString(R.string.nissan_condor_s),context.getString(R.string.nissan_condor_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_dualis),context.getString(R.string.nissan_dualis_s),context.getString(R.string.nissan_dualis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_dualis_2),context.getString(R.string.nissan_dualis_2_s),context.getString(R.string.nissan_dualis_2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_note),context.getString(R.string.nissan_note_s),context.getString(R.string.nissan_note_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_nv350),context.getString(R.string.nissan_nv350_s),context.getString(R.string.nissan_nv350_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_patrol_pickup),context.getString(R.string.nissan_patrol_pickup_s),context.getString(R.string.nissan_patrol_pickup_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_patrol_safari),context.getString(R.string.nissan_patrol_safari_s),context.getString(R.string.nissan_patrol_safari_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_teana),context.getString(R.string.nissan_teana_s),context.getString(R.string.nissan_teana_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_united_diesel),context.getString(R.string.nissan_united_diesel_s),context.getString(R.string.nissan_united_diesel_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_urvan),context.getString(R.string.nissan_urvan_s),context.getString(R.string.nissan_urvan_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.nissan_other),context.getString(R.string.nissan_other_s),context.getString(R.string.nissan_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.hummer)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.hummer_h1),context.getString(R.string.hummer_h1_s),context.getString(R.string.hummer_h1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hummer_h2),context.getString(R.string.hummer_h2_s),context.getString(R.string.hummer_h2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hummer_h3),context.getString(R.string.hummer_h3_s),context.getString(R.string.hummer_h3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hummer_other),context.getString(R.string.hummer_other_s),context.getString(R.string.hummer_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.honda)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_cr_v),context.getString(R.string.honda_cr_v_s),context.getString(R.string.honda_cr_v_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_vr_z),context.getString(R.string.honda_vr_z_s),context.getString(R.string.honda_vr_z_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_hr_v),context.getString(R.string.honda_hr_v_s),context.getString(R.string.honda_hr_v_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_mdx),context.getString(R.string.honda_mdx_s),context.getString(R.string.honda_mdx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_mr_v),context.getString(R.string.honda_mr_v_s),context.getString(R.string.honda_mr_v_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_nsx),context.getString(R.string.honda_nsx_s),context.getString(R.string.honda_nsx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_s2000),context.getString(R.string.honda_s2000_s),context.getString(R.string.honda_s2000_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_smx),context.getString(R.string.honda_smx_s),context.getString(R.string.honda_smx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_srx),context.getString(R.string.honda_srx_s),context.getString(R.string.honda_srx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_that_s),context.getString(R.string.honda_that_s_s),context.getString(R.string.honda_that_s_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_z),context.getString(R.string.honda_z_s),context.getString(R.string.honda_z_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_accord),context.getString(R.string.honda_accord_s),context.getString(R.string.honda_accord_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_odyssey),context.getString(R.string.honda_odyssey_s),context.getString(R.string.honda_odyssey_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_insight),context.getString(R.string.honda_insight_s),context.getString(R.string.honda_insight_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_inspire),context.getString(R.string.honda_inspire_s),context.getString(R.string.honda_inspire_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_fcx_clarity),context.getString(R.string.honda_fcx_clarity_s),context.getString(R.string.honda_fcx_clarity_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_avencier),context.getString(R.string.honda_avencier_s),context.getString(R.string.honda_avencier_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_element),context.getString(R.string.honda_element_s),context.getString(R.string.honda_element_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_integra),context.getString(R.string.honda_integra_s),context.getString(R.string.honda_integra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_orthia),context.getString(R.string.honda_orthia_s),context.getString(R.string.honda_orthia_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_edix),context.getString(R.string.honda_edix_s),context.getString(R.string.honda_edix_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_airwave),context.getString(R.string.honda_airwave_s),context.getString(R.string.honda_airwave_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_elysion),context.getString(R.string.honda_elysion_s),context.getString(R.string.honda_elysion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_partner),context.getString(R.string.honda_partner_s),context.getString(R.string.honda_partner_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_passport),context.getString(R.string.honda_passport_s),context.getString(R.string.honda_passport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_pilot),context.getString(R.string.honda_pilot_s),context.getString(R.string.honda_pilot_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_prelude),context.getString(R.string.honda_prelude_s),context.getString(R.string.honda_prelude_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_beat),context.getString(R.string.honda_beat_s),context.getString(R.string.honda_beat_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_today),context.getString(R.string.honda_today_s),context.getString(R.string.honda_today_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_domani),context.getString(R.string.honda_domani_s),context.getString(R.string.honda_domani_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_rafaga),context.getString(R.string.honda_rafaga_s),context.getString(R.string.honda_rafaga_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_ridgeline),context.getString(R.string.honda_ridgeline_s),context.getString(R.string.honda_ridgeline_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_step_wgn),context.getString(R.string.honda_step_wgn_s),context.getString(R.string.honda_step_wgn_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_stream),context.getString(R.string.honda_stream_s),context.getString(R.string.honda_stream_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_city),context.getString(R.string.honda_city_s),context.getString(R.string.honda_city_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_civic),context.getString(R.string.honda_civic_s),context.getString(R.string.honda_civic_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_shuttle),context.getString(R.string.honda_shuttle_s),context.getString(R.string.honda_shuttle_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_vamos),context.getString(R.string.honda_vamos_s),context.getString(R.string.honda_vamos_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_vigor),context.getString(R.string.honda_vigor_s),context.getString(R.string.honda_vigor_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_jazz),context.getString(R.string.honda_jazz_s),context.getString(R.string.honda_jazz_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_fit_aria),context.getString(R.string.honda_fit_aria_s),context.getString(R.string.honda_fit_aria_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_capa),context.getString(R.string.honda_capa_s),context.getString(R.string.honda_capa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_crossroad),context.getString(R.string.honda_crossroad_s),context.getString(R.string.honda_crossroad_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_concerto),context.getString(R.string.honda_concerto_s),context.getString(R.string.honda_concerto_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_quintet),context.getString(R.string.honda_quintet_s),context.getString(R.string.honda_quintet_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_laGreat),context.getString(R.string.honda_laGreat_s),context.getString(R.string.honda_laGreat_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_life),context.getString(R.string.honda_life_s),context.getString(R.string.honda_life_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_logo),context.getString(R.string.honda_logo_s),context.getString(R.string.honda_logo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_legend),context.getString(R.string.honda_legend_s),context.getString(R.string.honda_legend_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_mobilio),context.getString(R.string.honda_mobilio_s),context.getString(R.string.honda_mobilio_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_accord_Coupe),context.getString(R.string.honda_accord_Coupe_s),context.getString(R.string.honda_accord_Coupe_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.honda_other),context.getString(R.string.honda_other_s),context.getString(R.string.honda_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.geely)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_ck),context.getString(R.string.geely_ck_s),context.getString(R.string.geely_ck_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_gc2),context.getString(R.string.geely_gc2_s),context.getString(R.string.geely_gc2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_gc5),context.getString(R.string.geely_gc5_s),context.getString(R.string.geely_gc5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_gc6),context.getString(R.string.geely_gc6_s),context.getString(R.string.geely_gc6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_gc7),context.getString(R.string.geely_gc7_s),context.getString(R.string.geely_gc7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_gx2),context.getString(R.string.geely_gx2_s),context.getString(R.string.geely_gx2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_hq),context.getString(R.string.geely_hq_s),context.getString(R.string.geely_hq_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_lc),context.getString(R.string.geely_lc_s),context.getString(R.string.geely_lc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_mk_cross),context.getString(R.string.geely_mk_cross_s),context.getString(R.string.geely_mk_cross_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_sc7),context.getString(R.string.geely_sc7_s),context.getString(R.string.geely_sc7_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_emgrand_7),context.getString(R.string.geely_emgrand_7_s),context.getString(R.string.geely_emgrand_7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_emgrand_8),context.getString(R.string.geely_emgrand_8_s),context.getString(R.string.geely_emgrand_8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_emgrand_x7),context.getString(R.string.geely_emgrand_x7_s),context.getString(R.string.geely_emgrand_x7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_emgrand_gt),context.getString(R.string.geely_emgrand_gt_s),context.getString(R.string.geely_emgrand_gt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.geely_other),context.getString(R.string.geely_other_s),context.getString(R.string.geely_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.zxauto)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.zxauto_admiral),context.getString(R.string.zxauto_admiral_s),context.getString(R.string.zxauto_admiral_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.zxauto_grand_tiger),context.getString(R.string.zxauto_grand_tiger_s),context.getString(R.string.zxauto_grand_tiger_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.zxauto_other),context.getString(R.string.zxauto_other_s),context.getString(R.string.zxauto_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.mg)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_mg3),context.getString(R.string.mg_mg3_s),context.getString(R.string.mg_mg3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_mg5),context.getString(R.string.mg_mg5_s),context.getString(R.string.mg_mg5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_mg6),context.getString(R.string.mg_mg6_s),context.getString(R.string.mg_mg6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_350s),context.getString(R.string.mg_350s_s),context.getString(R.string.mg_350s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_550),context.getString(R.string.mg_550_s),context.getString(R.string.mg_550_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_mga),context.getString(R.string.mg_mga_s),context.getString(R.string.mg_mga_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_mgc),context.getString(R.string.mg_mgc_s),context.getString(R.string.mg_mgc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_midget),context.getString(R.string.mg_midget_s),context.getString(R.string.mg_midget_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mg_other),context.getString(R.string.mg_other_s),context.getString(R.string.mg_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.proton)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.proton_gen_2),context.getString(R.string.proton_gen_2_s),context.getString(R.string.proton_gen_2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.proton_persona),context.getString(R.string.proton_persona_s),context.getString(R.string.proton_persona_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.proton_waja),context.getString(R.string.proton_waja_s),context.getString(R.string.proton_waja_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.proton_other),context.getString(R.string.proton_other_s),context.getString(R.string.proton_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.brilliance)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_h220),context.getString(R.string.brilliance_h220_s),context.getString(R.string.brilliance_h220_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_h230),context.getString(R.string.brilliance_h230_s),context.getString(R.string.brilliance_h230_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_h320),context.getString(R.string.brilliance_h320_s),context.getString(R.string.brilliance_h320_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_h330),context.getString(R.string.brilliance_h330_s),context.getString(R.string.brilliance_h330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_h530),context.getString(R.string.brilliance_h530_s),context.getString(R.string.brilliance_h530_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_m1),context.getString(R.string.brilliance_m1_s),context.getString(R.string.brilliance_m1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_v5),context.getString(R.string.brilliance_v5_s),context.getString(R.string.brilliance_v5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.brilliance_other),context.getString(R.string.brilliance_other_s),context.getString(R.string.brilliance_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.byd)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_f0),context.getString(R.string.bdy_f0_s),context.getString(R.string.bdy_f0_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_f3r),context.getString(R.string.bdy_f3r_s),context.getString(R.string.bdy_f3r_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_f5),context.getString(R.string.bdy_f5_s),context.getString(R.string.bdy_f5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_f6),context.getString(R.string.bdy_f6_s),context.getString(R.string.bdy_f6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_f7),context.getString(R.string.bdy_f7_s),context.getString(R.string.bdy_f7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_g3),context.getString(R.string.bdy_g3_s),context.getString(R.string.bdy_g3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_s6),context.getString(R.string.bdy_s6_s),context.getString(R.string.bdy_s6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_e6),context.getString(R.string.bdy_e6_s),context.getString(R.string.bdy_e6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bdy_other),context.getString(R.string.bdy_other_s),context.getString(R.string.bdy_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.samsung)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.samsung_qm5),context.getString(R.string.samsung_qm5_s),context.getString(R.string.samsung_qm5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.samsung_qm3),context.getString(R.string.samsung_qm3_s),context.getString(R.string.samsung_qm3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.samsung_sm_3),context.getString(R.string.samsung_sm_3_s),context.getString(R.string.samsung_sm_3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.samsung_sm_5),context.getString(R.string.samsung_sm_5_s),context.getString(R.string.samsung_sm_5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.samsung_sm_6),context.getString(R.string.samsung_sm_6_s),context.getString(R.string.samsung_sm_6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.samsung_sm_7),context.getString(R.string.samsung_sm_7_s),context.getString(R.string.samsung_sm_7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.samsung_other),context.getString(R.string.samsung_other_s),context.getString(R.string.samsung_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.tesla)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.tesla_3),context.getString(R.string.tesla_3_s),context.getString(R.string.tesla_3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tesla_S),context.getString(R.string.tesla_S_s),context.getString(R.string.tesla_S_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tesla_X),context.getString(R.string.tesla_X_s),context.getString(R.string.tesla_X_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tesla_Other),context.getString(R.string.tesla_Other_s),context.getString(R.string.tesla_Other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.iran_khodro)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.iran_khodro_samand),context.getString(R.string.iran_khodro_samand_s),context.getString(R.string.iran_khodro_samand_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.iran_khodro_tiba),context.getString(R.string.iran_khodro_tiba_s),context.getString(R.string.iran_khodro_tiba_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.iran_khodro_other),context.getString(R.string.iran_khodro_other_s),context.getString(R.string.iran_khodro_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.tata)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_aria),context.getString(R.string.tata_aria_s),context.getString(R.string.tata_aria_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_indigo),context.getString(R.string.tata_indigo_s),context.getString(R.string.tata_indigo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_indica),context.getString(R.string.tata_indica_s),context.getString(R.string.tata_indica_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_bolt),context.getString(R.string.tata_bolt_s),context.getString(R.string.tata_bolt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_telcoline),context.getString(R.string.tata_telcoline_s),context.getString(R.string.tata_telcoline_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_tiago),context.getString(R.string.tata_tiago_s),context.getString(R.string.tata_tiago_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_genX_nano),context.getString(R.string.tata_genX_nano_s),context.getString(R.string.tata_genX_nano_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_xenon),context.getString(R.string.tata_xenon_s),context.getString(R.string.tata_xenon_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_safari),context.getString(R.string.tata_safari_s),context.getString(R.string.tata_safari_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_sumo),context.getString(R.string.tata_sumo_s),context.getString(R.string.tata_sumo_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_nano),context.getString(R.string.tata_nano_s),context.getString(R.string.tata_nano_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_613),context.getString(R.string.tata_613_s),context.getString(R.string.tata_613_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.tata_other),context.getString(R.string.tata_other_s),context.getString(R.string.tata_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.bugatti)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.bugatti_eb_110),context.getString(R.string.bugatti_eb_110_s),context.getString(R.string.bugatti_eb_110_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bugatti_chiron),context.getString(R.string.bugatti_chiron_s),context.getString(R.string.bugatti_chiron_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bugatti_grand_sport),context.getString(R.string.bugatti_grand_sport_s),context.getString(R.string.bugatti_grand_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bugatti_super_sport),context.getString(R.string.bugatti_super_sport_s),context.getString(R.string.bugatti_super_sport_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bugatti_veyron),context.getString(R.string.bugatti_veyron_s),context.getString(R.string.bugatti_veyron_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.bugatti_other),context.getString(R.string.bugatti_other_s),context.getString(R.string.bugatti_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.acura)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_cl),context.getString(R.string.acura_cl_s),context.getString(R.string.acura_cl_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_ilx),context.getString(R.string.acura_ilx_s),context.getString(R.string.acura_ilx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_mdx),context.getString(R.string.acura_mdx_s),context.getString(R.string.acura_mdx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_nsx),context.getString(R.string.acura_nsx_s),context.getString(R.string.acura_nsx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_rdx),context.getString(R.string.acura_rdx_s),context.getString(R.string.acura_rdx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_rl),context.getString(R.string.acura_rl_s),context.getString(R.string.acura_rl_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_rlx),context.getString(R.string.acura_rlx_s),context.getString(R.string.acura_rlx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_rsx),context.getString(R.string.acura_rsx_s),context.getString(R.string.acura_rsx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_tl),context.getString(R.string.acura_tl_s),context.getString(R.string.acura_tl_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_tlx),context.getString(R.string.acura_tlx_s),context.getString(R.string.acura_tlx_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_tsx),context.getString(R.string.acura_tsx_s),context.getString(R.string.acura_tsx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_zdx),context.getString(R.string.acura_zdx_s),context.getString(R.string.acura_zdx_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_integra),context.getString(R.string.acura_integra_s),context.getString(R.string.acura_integra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_legend),context.getString(R.string.acura_legend_s),context.getString(R.string.acura_legend_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.acura_other),context.getString(R.string.acura_other_s),context.getString(R.string.acura_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.scion)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_fr_s),context.getString(R.string.scion_fr_s_s),context.getString(R.string.scion_fr_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_ia),context.getString(R.string.scion_ia_s),context.getString(R.string.scion_ia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_im),context.getString(R.string.scion_im_s),context.getString(R.string.scion_im_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_tc),context.getString(R.string.scion_tc_s),context.getString(R.string.scion_tc_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_xa),context.getString(R.string.scion_xa_s),context.getString(R.string.scion_xa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_xb),context.getString(R.string.scion_xb_s),context.getString(R.string.scion_xb_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_xd),context.getString(R.string.scion_xd_s),context.getString(R.string.scion_xd_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_fuse),context.getString(R.string.scion_fuse_s),context.getString(R.string.scion_fuse_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.scion_other),context.getString(R.string.scion_other_s),context.getString(R.string.scion_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.mclaren)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.mclaren_540),context.getString(R.string.mclaren_540_s),context.getString(R.string.mclaren_540_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mclaren_570),context.getString(R.string.mclaren_570_s),context.getString(R.string.mclaren_570_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mclaren_650),context.getString(R.string.mclaren_650_s),context.getString(R.string.mclaren_650_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mclaren_675),context.getString(R.string.mclaren_675_s),context.getString(R.string.mclaren_675_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mclaren_12c),context.getString(R.string.mclaren_12c_s),context.getString(R.string.mclaren_12c_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mclaren_p1),context.getString(R.string.mclaren_p1_s),context.getString(R.string.mclaren_p1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.mclaren_other),context.getString(R.string.mclaren_other_s),context.getString(R.string.mclaren_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.pagani)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.pagani_zonda),context.getString(R.string.pagani_zonda_s),context.getString(R.string.pagani_zonda_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.pagani_huayra),context.getString(R.string.pagani_huayra_s),context.getString(R.string.pagani_huayra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.pagani_other),context.getString(R.string.pagani_other_s),context.getString(R.string.pagani_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.lancia)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_thesis),context.getString(R.string.lancia_thesis_s),context.getString(R.string.lancia_thesis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_thema),context.getString(R.string.lancia_thema_s),context.getString(R.string.lancia_thema_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_delta),context.getString(R.string.lancia_delta_s),context.getString(R.string.lancia_delta_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_dedra),context.getString(R.string.lancia_dedra_s),context.getString(R.string.lancia_dedra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_flavia),context.getString(R.string.lancia_flavia_s),context.getString(R.string.lancia_flavia_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_voyager),context.getString(R.string.lancia_voyager_s),context.getString(R.string.lancia_voyager_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_kappa),context.getString(R.string.lancia_kappa_s),context.getString(R.string.lancia_kappa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_lybra),context.getString(R.string.lancia_lybra_s),context.getString(R.string.lancia_lybra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_musa),context.getString(R.string.lancia_musa_s),context.getString(R.string.lancia_musa_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_ypsilon),context.getString(R.string.lancia_ypsilon_s),context.getString(R.string.lancia_ypsilon_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_stratos),context.getString(R.string.lancia_stratos_s),context.getString(R.string.lancia_stratos_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lancia_other),context.getString(R.string.lancia_other_s),context.getString(R.string.lancia_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.jac)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_iev_5),context.getString(R.string.jac_iev_5_s),context.getString(R.string.jac_iev_5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_iev_6),context.getString(R.string.jac_iev_6_s),context.getString(R.string.jac_iev_6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_s1),context.getString(R.string.jac_s1_s),context.getString(R.string.jac_s1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_s2),context.getString(R.string.jac_s2_s),context.getString(R.string.jac_s2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_s3),context.getString(R.string.jac_s3_s),context.getString(R.string.jac_s3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_s5),context.getString(R.string.jac_s5_s),context.getString(R.string.jac_s5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_s7),context.getString(R.string.jac_s7_s),context.getString(R.string.jac_s7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_spv),context.getString(R.string.jac_spv_s),context.getString(R.string.jac_spv_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_x200),context.getString(R.string.jac_x200_s),context.getString(R.string.jac_x200_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_m3),context.getString(R.string.jac_m3_s),context.getString(R.string.jac_m3_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_m4),context.getString(R.string.jac_m4_s),context.getString(R.string.jac_m4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_m5),context.getString(R.string.jac_m5_s),context.getString(R.string.jac_m5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_a60),context.getString(R.string.jac_a60_s),context.getString(R.string.jac_a60_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_t6_frison),context.getString(R.string.jac_t6_frison_s),context.getString(R.string.jac_t6_frison_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_j4),context.getString(R.string.jac_j4_s),context.getString(R.string.jac_j4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_n_series),context.getString(R.string.jac_n_series_s),context.getString(R.string.jac_n_series_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_v1),context.getString(R.string.jac_v1_s),context.getString(R.string.jac_v1_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_ga8),context.getString(R.string.jac_ga8_s),context.getString(R.string.jac_ga8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_gs3),context.getString(R.string.jac_gs3_s),context.getString(R.string.jac_gs3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_gs4),context.getString(R.string.jac_gs4_s),context.getString(R.string.jac_gs4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_gs5),context.getString(R.string.jac_gs5_s),context.getString(R.string.jac_gs5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_gs7),context.getString(R.string.jac_gs7_s),context.getString(R.string.jac_gs7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_gs8),context.getString(R.string.jac_gs8_s),context.getString(R.string.jac_gs8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_gn6),context.getString(R.string.jac_gn6_s),context.getString(R.string.jac_gn6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_gn8),context.getString(R.string.jac_gn8_s),context.getString(R.string.jac_gn8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_ge3),context.getString(R.string.jac_ge3_s),context.getString(R.string.jac_ge3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.jac_other),context.getString(R.string.jac_other_s),context.getString(R.string.jac_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.lifan)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_1022),context.getString(R.string.lifan_1022_s),context.getString(R.string.lifan_1022_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_1025),context.getString(R.string.lifan_1025_s),context.getString(R.string.lifan_1025_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_320e),context.getString(R.string.lifan_320e_s),context.getString(R.string.lifan_320e_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_330),context.getString(R.string.lifan_330_s),context.getString(R.string.lifan_330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_330ev),context.getString(R.string.lifan_330ev_s),context.getString(R.string.lifan_330ev_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_620ii),context.getString(R.string.lifan_620ii_s),context.getString(R.string.lifan_620ii_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_650ev),context.getString(R.string.lifan_650ev_s),context.getString(R.string.lifan_650ev_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_820),context.getString(R.string.lifan_820_s),context.getString(R.string.lifan_820_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_c3),context.getString(R.string.lifan_c3_s),context.getString(R.string.lifan_c3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_c30E),context.getString(R.string.lifan_c30E_s),context.getString(R.string.lifan_c30E_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_foison),context.getString(R.string.lifan_foison_s),context.getString(R.string.lifan_foison_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_l7),context.getString(R.string.lifan_l7_s),context.getString(R.string.lifan_l7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_m7),context.getString(R.string.lifan_m7_s),context.getString(R.string.lifan_m7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_seasion),context.getString(R.string.lifan_seasion_s),context.getString(R.string.lifan_seasion_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_x50),context.getString(R.string.lifan_x50_s),context.getString(R.string.lifan_x50_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_x60),context.getString(R.string.lifan_x60_s),context.getString(R.string.lifan_x60_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_x7),context.getString(R.string.lifan_x7_s),context.getString(R.string.lifan_x7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_x70),context.getString(R.string.lifan_x70_s),context.getString(R.string.lifan_x70_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.lifan_x80),context.getString(R.string.lifan_x80_s),context.getString(R.string.lifan_x80_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.faw)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_b30),context.getString(R.string.faw_b30_s),context.getString(R.string.faw_b30_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_b50),context.getString(R.string.faw_b50_s),context.getString(R.string.faw_b50_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_b70),context.getString(R.string.faw_b70_s),context.getString(R.string.faw_b70_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_j5k_165),context.getString(R.string.faw_j5k_165_s),context.getString(R.string.faw_j5k_165_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_j5m),context.getString(R.string.faw_j5m_s),context.getString(R.string.faw_j5m_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_j5m_220),context.getString(R.string.faw_j5m_220_s),context.getString(R.string.faw_j5m_220_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_j5m_280),context.getString(R.string.faw_j5m_280_s),context.getString(R.string.faw_j5m_280_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_j5P_330),context.getString(R.string.faw_j5P_330_s),context.getString(R.string.faw_j5P_330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_j5P_420),context.getString(R.string.faw_j5P_420_s),context.getString(R.string.faw_j5P_420_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_v2),context.getString(R.string.faw_v2_s),context.getString(R.string.faw_v2_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_x40),context.getString(R.string.faw_x40_s),context.getString(R.string.faw_x40_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_x80),context.getString(R.string.faw_x80_s),context.getString(R.string.faw_x80_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_xPV),context.getString(R.string.faw_xPV_s),context.getString(R.string.faw_xPV_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_actis_v80_v80L),context.getString(R.string.faw_actis_v80_v80L_s),context.getString(R.string.faw_actis_v80_v80L_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_tiger_v),context.getString(R.string.faw_tiger_v_s),context.getString(R.string.faw_tiger_v_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_carrier),context.getString(R.string.faw_carrier_s),context.getString(R.string.faw_carrier_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_mini_truck_t80),context.getString(R.string.faw_mini_truck_t80_s),context.getString(R.string.faw_mini_truck_t80_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.faw_hongqi_h7),context.getString(R.string.faw_hongqi_h7_s),context.getString(R.string.faw_hongqi_h7_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.foton)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_toana),context.getString(R.string.foton_toana_s),context.getString(R.string.foton_toana_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_toplander),context.getString(R.string.foton_toplander_s),context.getString(R.string.foton_toplander_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_tornado),context.getString(R.string.foton_tornado_s),context.getString(R.string.foton_tornado_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_thunder),context.getString(R.string.foton_thunder_s),context.getString(R.string.foton_thunder_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_gratour),context.getString(R.string.foton_gratour_s),context.getString(R.string.foton_gratour_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_view_traveller),context.getString(R.string.foton_view_traveller_s),context.getString(R.string.foton_view_traveller_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_view_transvan),context.getString(R.string.foton_view_transvan_s),context.getString(R.string.foton_view_transvan_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_sauvana),context.getString(R.string.foton_sauvana_s),context.getString(R.string.foton_sauvana_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_tunland),context.getString(R.string.foton_tunland_s),context.getString(R.string.foton_tunland_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_view_c1),context.getString(R.string.foton_view_c1_s),context.getString(R.string.foton_view_c1_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_view_c2),context.getString(R.string.foton_view_c2_s),context.getString(R.string.foton_view_c2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_view_cs2),context.getString(R.string.foton_view_cs2_s),context.getString(R.string.foton_view_cs2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_aumark_s),context.getString(R.string.foton_aumark_s_s),context.getString(R.string.foton_aumark_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_aumark_c),context.getString(R.string.foton_aumark_c_s),context.getString(R.string.foton_aumark_c_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.foton_aumark_tx),context.getString(R.string.foton_aumark_tx_s),context.getString(R.string.foton_aumark_tx_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.maruti_suzuki)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_eeco),context.getString(R.string.maruti_Suzuki_eeco_s),context.getString(R.string.maruti_Suzuki_eeco_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_ignis),context.getString(R.string.maruti_Suzuki_ignis_s),context.getString(R.string.maruti_Suzuki_ignis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_ertiga),context.getString(R.string.maruti_Suzuki_ertiga_s),context.getString(R.string.maruti_Suzuki_ertiga_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_s_cross),context.getString(R.string.maruti_Suzuki_s_cross_s),context.getString(R.string.maruti_Suzuki_s_cross_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_alto_800),context.getString(R.string.maruti_Suzuki_alto_800_s),context.getString(R.string.maruti_Suzuki_alto_800_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_alto_k10),context.getString(R.string.maruti_Suzuki_alto_k10_s),context.getString(R.string.maruti_Suzuki_alto_k10_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_omni),context.getString(R.string.maruti_Suzuki_omni_s),context.getString(R.string.maruti_Suzuki_omni_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_baleno),context.getString(R.string.maruti_Suzuki_baleno_s),context.getString(R.string.maruti_Suzuki_baleno_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_baleno_car_s),context.getString(R.string.maruti_Suzuki_baleno_car_s_s),context.getString(R.string.maruti_Suzuki_baleno_car_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_gypsy),context.getString(R.string.maruti_Suzuki_gypsy_s),context.getString(R.string.maruti_Suzuki_gypsy_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_jimny),context.getString(R.string.maruti_Suzuki_jimny_s),context.getString(R.string.maruti_Suzuki_jimny_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_dzire),context.getString(R.string.maruti_Suzuki_dzire_s),context.getString(R.string.maruti_Suzuki_dzire_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_swift),context.getString(R.string.maruti_Suzuki_swift_s),context.getString(R.string.maruti_Suzuki_swift_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_ciaz),context.getString(R.string.maruti_Suzuki_ciaz_s),context.getString(R.string.maruti_Suzuki_ciaz_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_ciaz_car_s),context.getString(R.string.maruti_Suzuki_ciaz_s_car_s),context.getString(R.string.maruti_Suzuki_ciaz_car_s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_celerio),context.getString(R.string.maruti_Suzuki_celerio_s),context.getString(R.string.maruti_Suzuki_celerio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_celerio_x),context.getString(R.string.maruti_Suzuki_celerio_x_s),context.getString(R.string.maruti_Suzuki_celerio_x_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_vitara_brezza),context.getString(R.string.maruti_Suzuki_vitara_brezza_s),context.getString(R.string.maruti_Suzuki_vitara_brezza_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.maruti_Suzuki_wagon_r),context.getString(R.string.maruti_Suzuki_wagon_r_s),context.getString(R.string.maruti_Suzuki_wagon_r_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.saipa)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_111),context.getString(R.string.saipa_111_s),context.getString(R.string.saipa_111_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_131),context.getString(R.string.saipa_131_s),context.getString(R.string.saipa_131_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_132),context.getString(R.string.saipa_132_s),context.getString(R.string.saipa_132_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_141),context.getString(R.string.saipa_141_s),context.getString(R.string.saipa_141_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_cs35),context.getString(R.string.saipa_cs35_s),context.getString(R.string.saipa_cs35_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_d_375),context.getString(R.string.saipa_d_375_s),context.getString(R.string.saipa_d_375_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_fh500),context.getString(R.string.saipa_fh500_s),context.getString(R.string.saipa_fh500_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_fm460),context.getString(R.string.saipa_fm460_s),context.getString(R.string.saipa_fm460_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_h220),context.getString(R.string.saipa_h220_s),context.getString(R.string.saipa_h220_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_h230),context.getString(R.string.saipa_h230_s),context.getString(R.string.saipa_h230_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_h320),context.getString(R.string.saipa_h320_s),context.getString(R.string.saipa_h320_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_h330),context.getString(R.string.saipa_h330_s),context.getString(R.string.saipa_h330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_r270),context.getString(R.string.saipa_r270_s),context.getString(R.string.saipa_r270_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_ario),context.getString(R.string.saipa_ario_s),context.getString(R.string.saipa_ario_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_azar_van),context.getString(R.string.saipa_azar_van_s),context.getString(R.string.saipa_azar_van_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_eado),context.getString(R.string.saipa_eado_s),context.getString(R.string.saipa_eado_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_padra),context.getString(R.string.saipa_padra_s),context.getString(R.string.saipa_padra_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_tondar_90),context.getString(R.string.saipa_tondar_90_s),context.getString(R.string.saipa_tondar_90_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_tiba),context.getString(R.string.saipa_tiba_s),context.getString(R.string.saipa_tiba_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_roniz),context.getString(R.string.saipa_roniz_s),context.getString(R.string.saipa_roniz_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_rich),context.getString(R.string.saipa_rich_s),context.getString(R.string.saipa_rich_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_rio),context.getString(R.string.saipa_rio_s),context.getString(R.string.saipa_rio_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_sandero),context.getString(R.string.saipa_sandero_s),context.getString(R.string.saipa_sandero_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_saina),context.getString(R.string.saipa_saina_s),context.getString(R.string.saipa_saina_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_stralis),context.getString(R.string.saipa_stralis_s),context.getString(R.string.saipa_stralis_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_cerato),context.getString(R.string.saipa_cerato_s),context.getString(R.string.saipa_cerato_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_shooka),context.getString(R.string.saipa_shooka_s),context.getString(R.string.saipa_shooka_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_foton),context.getString(R.string.saipa_foton_s),context.getString(R.string.saipa_foton_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_qashqai),context.getString(R.string.saipa_qashqai_s),context.getString(R.string.saipa_qashqai_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_koleos),context.getString(R.string.saipa_koleos_s),context.getString(R.string.saipa_koleos_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_maxima),context.getString(R.string.saipa_maxima_s),context.getString(R.string.saipa_maxima_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_new_pickup),context.getString(R.string.saipa_new_pickup_s),context.getString(R.string.saipa_new_pickup_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_new_murano),context.getString(R.string.saipa_new_murano_s),context.getString(R.string.saipa_new_murano_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_quick),context.getString(R.string.saipa_quick_s),context.getString(R.string.saipa_quick_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.saipa_other),context.getString(R.string.saipa_other_s),context.getString(R.string.saipa_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.private_type)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.private_coupec),context.getString(R.string.private_coupec_s),context.getString(R.string.private_coupec_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.private_coupec),context.getString(R.string.private_coupec_s),context.getString(R.string.private_coupec_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.baic)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.baic_grand_tiger),context.getString(R.string.baic_grand_tiger_s),context.getString(R.string.baic_grand_tiger_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.baic_x65),context.getString(R.string.baic_x65_s),context.getString(R.string.baic_x65_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.baic_bJ40),context.getString(R.string.baic_bJ40_s),context.getString(R.string.baic_bJ40_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.baic_a113),context.getString(R.string.baic_a113_s),context.getString(R.string.baic_a113_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.baic_a115),context.getString(R.string.baic_a115_s),context.getString(R.string.baic_a115_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.baic_x35),context.getString(R.string.baic_x35_s),context.getString(R.string.baic_x35_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.changan)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_cx20),context.getString(R.string.changan_cx20_s),context.getString(R.string.changan_cx20_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_cx30),context.getString(R.string.changan_cx30_s),context.getString(R.string.changan_cx30_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_sania),context.getString(R.string.changan_sania_s),context.getString(R.string.changan_sania_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_eado),context.getString(R.string.changan_eado_s),context.getString(R.string.changan_eado_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_v7),context.getString(R.string.changan_v7_s),context.getString(R.string.changan_v7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_xt),context.getString(R.string.changan_xt_s),context.getString(R.string.changan_xt_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_raeton),context.getString(R.string.changan_raeton_s),context.getString(R.string.changan_raeton_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_cs35),context.getString(R.string.changan_cs35_s),context.getString(R.string.changan_cs35_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_cs75),context.getString(R.string.changan_cs75_s),context.getString(R.string.changan_cs75_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_cs85),context.getString(R.string.changan_cs85_s),context.getString(R.string.changan_cs85_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_cs95),context.getString(R.string.changan_cs95_s),context.getString(R.string.changan_cs95_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.changan_benni_mini),context.getString(R.string.changan_benni_mini_s),context.getString(R.string.changan_benni_mini_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.hunaghai)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.hunaghai_n1),context.getString(R.string.hunaghai_n1_s),context.getString(R.string.hunaghai_n1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hunaghai_n1s),context.getString(R.string.hunaghai_n1s_s),context.getString(R.string.hunaghai_n1s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hunaghai_n2),context.getString(R.string.hunaghai_n2_s),context.getString(R.string.hunaghai_n2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hunaghai_n3),context.getString(R.string.hunaghai_n3_s),context.getString(R.string.hunaghai_n3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hunaghai_dd6591dm),context.getString(R.string.hunaghai_dd6591dm_s),context.getString(R.string.hunaghai_dd6591dm_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hunaghai_dd6534gl),context.getString(R.string.hunaghai_dd6534gl_s),context.getString(R.string.hunaghai_dd6534gl_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.hunaghai_dd6600ev),context.getString(R.string.hunaghai_dd6600ev_s),context.getString(R.string.hunaghai_dd6600ev_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.dfm)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_370),context.getString(R.string.dfm_370_s),context.getString(R.string.dfm_370_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_580),context.getString(R.string.dfm_580_s),context.getString(R.string.dfm_580_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_a30),context.getString(R.string.dfm_a30_s),context.getString(R.string.dfm_a30_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_a60),context.getString(R.string.dfm_a60_s),context.getString(R.string.dfm_a60_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_a9),context.getString(R.string.dfm_a9_s),context.getString(R.string.dfm_a9_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_ax3),context.getString(R.string.dfm_ax3_s),context.getString(R.string.dfm_ax3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_ax4),context.getString(R.string.dfm_ax4_s),context.getString(R.string.dfm_ax4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_xa5),context.getString(R.string.dfm_xa5_s),context.getString(R.string.dfm_xa5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_xa7),context.getString(R.string.dfm_xa7_s),context.getString(R.string.dfm_xa7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_c37),context.getString(R.string.dfm_c37_s),context.getString(R.string.dfm_c37_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_cM7),context.getString(R.string.dfm_cM7_s),context.getString(R.string.dfm_cM7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_e70),context.getString(R.string.dfm_e70_s),context.getString(R.string.dfm_e70_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_f600),context.getString(R.string.dfm_f600_s),context.getString(R.string.dfm_f600_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_glory_330),context.getString(R.string.dfm_glory_330_s),context.getString(R.string.dfm_glory_330_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_glory_360),context.getString(R.string.dfm_glory_360_s),context.getString(R.string.dfm_glory_360_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_h30_cross),context.getString(R.string.dfm_h30_cross_s),context.getString(R.string.dfm_h30_cross_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_joyear_lv),context.getString(R.string.dfm_joyear_lv_s),context.getString(R.string.dfm_joyear_lv_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_joyear_x3),context.getString(R.string.dfm_joyear_x3_s),context.getString(R.string.dfm_joyear_x3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_joyear_x5),context.getString(R.string.dfm_joyear_x5_s),context.getString(R.string.dfm_joyear_x5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.audi_a),context.getString(R.string.audi_a_s),context.getString(R.string.audi_a_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_joyear_xl),context.getString(R.string.dfm_joyear_xl_s),context.getString(R.string.dfm_joyear_xl_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_joyear_xv),context.getString(R.string.dfm_joyear_xv_s),context.getString(R.string.dfm_joyear_xv_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_l60),context.getString(R.string.dfm_l60_s),context.getString(R.string.dfm_l60_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_m3),context.getString(R.string.dfm_m3_s),context.getString(R.string.dfm_m3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_m5),context.getString(R.string.dfm_m5_s),context.getString(R.string.dfm_m5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_mx6),context.getString(R.string.dfm_mx6_s),context.getString(R.string.dfm_mx6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_rich),context.getString(R.string.dfm_rich_s),context.getString(R.string.dfm_rich_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_succe),context.getString(R.string.dfm_succe_s),context.getString(R.string.dfm_succe_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_sx6),context.getString(R.string.dfm_sx6_s),context.getString(R.string.dfm_sx6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_u_vane),context.getString(R.string.dfm_u_vane_s),context.getString(R.string.dfm_u_vane_ar)));
//
//            carModelArrayList.add(new CarModel(context.getString(R.string.dfm_v3),context.getString(R.string.dfm_v3_s),context.getString(R.string.dfm_v3_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.borgward)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.borgward_bx7_ts),context.getString(R.string.borgward_bx7_ts_s),context.getString(R.string.borgward_bx7_ts_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.borgward_bx7),context.getString(R.string.borgward_bx7_s),context.getString(R.string.borgward_bx7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.borgward_bx5),context.getString(R.string.borgward_bx5_s),context.getString(R.string.borgward_bx5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.borgward_bx6_ts),context.getString(R.string.borgward_bx6_ts_s),context.getString(R.string.borgward_bx6_ts_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.borgward_bxi7),context.getString(R.string.borgward_bxi7_s),context.getString(R.string.borgward_bxi7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.borgward_other),context.getString(R.string.borgward_other_s),context.getString(R.string.borgward_other_ar)));
//
//        }
//        if (carMake.equals(context.getString(R.string.iveco)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.iveco_new_daily),context.getString(R.string.iveco_new_daily_s),context.getString(R.string.iveco_new_daily_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.iveco_eurocargo),context.getString(R.string.iveco_eurocargo_s),context.getString(R.string.iveco_eurocargo_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.iveco_new_strails),context.getString(R.string.iveco_new_strails_s),context.getString(R.string.iveco_new_strails_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.iveco_new_trakker),context.getString(R.string.iveco_new_trakker_s),context.getString(R.string.iveco_new_trakker_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.iveco_other),context.getString(R.string.iveco_other_s),context.getString(R.string.iveco_other_ar)));
//        }
//        if (carMake.equals(context.getString(R.string.haval)))
//        {
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h1),context.getString(R.string.haval_h1_s),context.getString(R.string.haval_h1_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h2),context.getString(R.string.haval_h2_s),context.getString(R.string.haval_h2_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h2s),context.getString(R.string.haval_h2s_s),context.getString(R.string.haval_h2s_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h3),context.getString(R.string.haval_h3_s),context.getString(R.string.haval_h3_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h4),context.getString(R.string.haval_h4_s),context.getString(R.string.haval_h4_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h5),context.getString(R.string.haval_h5_s),context.getString(R.string.haval_h5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h6),context.getString(R.string.haval_h6_s),context.getString(R.string.haval_h6_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h7),context.getString(R.string.haval_h7_s),context.getString(R.string.haval_h7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h8),context.getString(R.string.haval_h8_s),context.getString(R.string.haval_h8_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_h9),context.getString(R.string.haval_h9_s),context.getString(R.string.haval_h9_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_m6),context.getString(R.string.haval_m6_s),context.getString(R.string.haval_m6_ar_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_f5),context.getString(R.string.haval_f5_s),context.getString(R.string.haval_f5_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_f7),context.getString(R.string.haval_f7_s),context.getString(R.string.haval_f7_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_f7x),context.getString(R.string.haval_f7x_s),context.getString(R.string.haval_f7x_ar)));
//            carModelArrayList.add(new CarModel(context.getString(R.string.haval_other),context.getString(R.string.haval_other_s),context.getString(R.string.haval_other_ar)));
//        }
//
//            return carModelArrayList;
//    }


    public static ArrayList<CarMakeAndCarModel> fillAllCarArrayL(Context context)
    {
        ArrayList<CarMakeAndCarModel> allCarArrayList = new ArrayList<>();

        ArrayList<CarMake> carMakeArrayList  = new ArrayList<CarMake>();
        ArrayList<CarModel> carModelArrayL  = new ArrayList<CarModel>();

//        carMakeArrayList = fillCarMakeArrayL(carMakeArrayList,context);
//
//        for (int i =0 ;i<carMakeArrayList.size();i++)
//        {
//            carModelArrayL  = new ArrayList<CarModel>();
//            carModelArrayL = fillCarModelArrayL(carModelArrayL,context,carMakeArrayList.get(i).getMakeStr());
//            for (int j =0;j<carModelArrayL.size();j++)
//            {
//                CarMakeAndCarModel carMakeAndCarModel = new CarMakeAndCarModel
//                        (carMakeArrayList.get(i).getMakeStr()
//                        ,carMakeArrayList.get(i).getMakeStrS()
//                                ,carModelArrayL.get(j).getCarModelStr()
//                                ,carModelArrayL.get(j).getCarModelStrS()
//                        );
//                allCarArrayList.add(carMakeAndCarModel);
//            }
//
//        }

        return allCarArrayList;
    }

    public static ArrayList<SearchCar> fillAllCarArrayL2(Context context)
    {
        ArrayList<SearchCar> allCarArrayList = new ArrayList<>();

        ArrayList<CarMake> carMakeArrayList  = new ArrayList<CarMake>();
        ArrayList<CarModel> carModelArrayL  = new ArrayList<CarModel>();

        carMakeArrayList = getBrands(context);

        for (int i =0 ;i<carMakeArrayList.size();i++)
        {
            carModelArrayL  = new ArrayList<CarModel>();
            String nameBrand,modelName;
            if (getUserLanguage(context).equals("en"))
            {
                nameBrand = carMakeArrayList.get(i).getName_en();
            }else{
                nameBrand = carMakeArrayList.get(i).getName_ar();
            }
            carModelArrayL = getModelsToSpecificBrand(context,carMakeArrayList.get(i).getName_en());
            for (int j =0;j<carModelArrayL.size();j++)
            {
                String im ="https://firebasestorage.googleapis.com/v0/b/hala-motor-8ff46.appspot.com/o/carLogos%2Fbmw.png?alt=media&token=7c5e9d9f-1fdc-4722-beea-4814203bc904";

                if (getUserLanguage(context).equals("en"))
                {
                    modelName = carModelArrayL.get(i).getModel_name_en();
                }else{
                    modelName = carModelArrayL.get(i).getModel_name_ar();
                }

                SearchCar searchCarSale = new SearchCar(im
                        ,context.getResources().getString(R.string.car_for_sale)
                        ,context.getResources().getString(R.string.car_for_sale_s)

                        ,nameBrand
                        ,carMakeArrayList.get(i).getName_en()

                        ,modelName
                        ,carModelArrayL.get(i).getModel_name_en()
                );

                SearchCar searchCarRent = new SearchCar(im
                        ,context.getResources().getString(R.string.car_for_rent)
                        ,context.getResources().getString(R.string.car_for_rent_s)

                        ,nameBrand
                        ,carMakeArrayList.get(i).getName_en()

                        ,modelName
                        ,carModelArrayL.get(i).getModel_name_en()
                );
                allCarArrayList.add(searchCarSale);
                allCarArrayList.add(searchCarRent);
            }

        }

        return allCarArrayList;
    }

    public static ArrayList<ItemFilterModel> fillCarmodelFilterArrayL(Context context,String carMake) {
        ArrayList<ItemFilterModel>carModelFilterArrayList = new ArrayList<ItemFilterModel>();

        ArrayList<CarModel>carModelArrayList = new ArrayList<CarModel>();
        carModelArrayList = getModelsToSpecificBrand(context,carMake);
        String modelName;
        for (int i = 0;i<carModelArrayList.size();i++)
        {
            if (getUserLanguage(context).equals("en"))
            {
                modelName = carModelArrayList.get(i).getModel_name_en();
            }else{
                modelName = carModelArrayList.get(i).getModel_name_ar();
            }

            ItemFilterModel itemFilterModel = new ItemFilterModel(
                    modelName
                    ,carModelArrayList.get(i).getModel_name_en()
            );
            carModelFilterArrayList.add(itemFilterModel);
        }
        return carModelFilterArrayList;
    }

}
