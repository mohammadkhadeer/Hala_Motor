package com.cars.halamotor_obeidat.functions;

import android.content.Context;
import android.database.Cursor;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.City;
import com.cars.halamotor_obeidat.model.CityModel;
import com.cars.halamotor_obeidat.model.CityWithNeighborhood;
import com.cars.halamotor_obeidat.model.Neighborhood;
import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.sharedPreferences.AddressSharedPreferences.getUserNeighborhoodFromSP;

public class FillNeighborhood {

    public static ArrayList<CityModel> fillCityArrayL(Context context) {
        ArrayList<CityModel> cityArrayL = new ArrayList<>();
        ArrayList<CityModel> cityArrayL2 = new ArrayList<>();

        Cursor res = getDataBaseInstance(context).descendingCities();

        while (res.moveToNext()) {

            City city= new City(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
                    ,res.getString(5).replace("\n", "")
            );
//            Log.i("TAG","City res.getString(1).replace "+res.getString(1).replace("\n", ""));
//            Log.i("TAG","City res.getString(2).replace "+res.getString(2).replace("\n", ""));
//            Log.i("TAG","City res.getString(3).replace "+res.getString(3).replace("\n", ""));
//            Log.i("TAG","City res.getString(4).replace "+res.getString(4).replace("\n", ""));
//            Log.i("TAG","City res.getString(5).replace "+res.getString(5).replace("\n", ""));

            cityArrayL.add(new CityModel(city.getName_en(),city.getId(),city.getName_ar()));
        }

        for (int i=0;i<cityArrayL.size();i++)
        {
            int t=cityArrayL.size()-1;
            int po = t-i;
            cityArrayL2.add(cityArrayL.get(po));
        }

        return cityArrayL2;
    }

    public static ArrayList<Neighborhood> fillNeighborhoodArrayLFromDataBase(Context context,String cityCode) {

        ArrayList<Neighborhood> areasArrayList = new ArrayList<Neighborhood>();

        Cursor res = getDataBaseInstance(context).descendingAreas();
        Neighborhood area;
        while (res.moveToNext()) {

            if (cityCode.equals(res.getString(5).replace("\n", "")))
            {
                 area = new Neighborhood(res.getString(3).replace("\n", "")
                        ,res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", ""));

                areasArrayList.add(area);
            }

        }

        return areasArrayList;
    }

    public static ArrayList<Neighborhood> fillNeighborhoodArrayL
            (ArrayList<Neighborhood> neighborhoodArrayL, Context context, String city) {

        neighborhoodArrayL = new ArrayList<Neighborhood>();

        if (city.equals(context.getResources().getString(R.string.dubai)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.dubai_acacia),context.getResources().getString(R.string.dubai_acacia_s),context.getResources().getString(R.string.dubai_acacia_ar));
            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.dubai_academic),context.getResources().getString(R.string.dubai_academic_s),context.getResources().getString(R.string.dubai_academic_ar));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.dubai_alaweer),context.getResources().getString(R.string.dubai_alaweer_s),context.getResources().getString(R.string.dubai_alaweer_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.dubai_albadaa),context.getResources().getString(R.string.dubai_albadaa_s),context.getResources().getString(R.string.dubai_albadaa_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.dubai_albarari),context.getResources().getString(R.string.dubai_albarari_s),context.getResources().getString(R.string.dubai_albarari_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.dubai_albarsha),context.getResources().getString(R.string.dubai_albarsha_s),context.getResources().getString(R.string.dubai_albarsha_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.dubai_al_furjan),context.getResources().getString(R.string.dubai_al_furjan_s),context.getResources().getString(R.string.dubai_al_furjan_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.dubai_al_garhoud),context.getResources().getString(R.string.dubai_al_garhoud_s),context.getResources().getString(R.string.dubai_al_garhoud_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.dubai_al_hamriya),context.getResources().getString(R.string.dubai_al_hamriya_s),context.getResources().getString(R.string.dubai_al_hamriya_ar));

            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.dubai_al_jaddaf),context.getResources().getString(R.string.dubai_al_jaddaf_s),context.getResources().getString(R.string.dubai_al_jaddaf_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.dubai_al_jafiliya),context.getResources().getString(R.string.dubai_al_jafiliya_s),context.getResources().getString(R.string.dubai_al_jafiliya_ar));
            Neighborhood subFavorite12 = new Neighborhood(context.getResources().getString(R.string.dubai_al_khawaneej),context.getResources().getString(R.string.dubai_al_khawaneej_s),context.getResources().getString(R.string.dubai_al_khawaneej_ar));
            Neighborhood subFavorite13 = new Neighborhood(context.getResources().getString(R.string.dubai_al_mizhar),context.getResources().getString(R.string.dubai_al_mizhar_s),context.getResources().getString(R.string.dubai_al_mizhar_ar));
            Neighborhood subFavorite14 = new Neighborhood(context.getResources().getString(R.string.dubai_al_muhaisnah),context.getResources().getString(R.string.dubai_al_muhaisnah_s),context.getResources().getString(R.string.dubai_al_muhaisnah_ar));
            Neighborhood subFavorite15 = new Neighborhood(context.getResources().getString(R.string.dubai_al_nahda),context.getResources().getString(R.string.dubai_al_nahda_s),context.getResources().getString(R.string.dubai_al_nahda_ar));
            Neighborhood subFavorite16 = new Neighborhood(context.getResources().getString(R.string.dubai_al_quoz),context.getResources().getString(R.string.dubai_al_quoz_s),context.getResources().getString(R.string.dubai_al_quoz_ar));
            Neighborhood subFavorite17 = new Neighborhood(context.getResources().getString(R.string.dubai_al_qusais),context.getResources().getString(R.string.dubai_al_qusais_s),context.getResources().getString(R.string.dubai_al_qusais_ar));
            Neighborhood subFavorite18 = new Neighborhood(context.getResources().getString(R.string.dubai_al_rashidiya),context.getResources().getString(R.string.dubai_al_rashidiya_s),context.getResources().getString(R.string.dubai_al_rashidiya_ar));
            Neighborhood subFavorite19 = new Neighborhood(context.getResources().getString(R.string.dubai_al_safa),context.getResources().getString(R.string.dubai_al_safa_s),context.getResources().getString(R.string.dubai_al_safa_ar));

            Neighborhood subFavorite20 = new Neighborhood(context.getResources().getString(R.string.dubai_al_satwa),context.getResources().getString(R.string.dubai_al_satwa_s),context.getResources().getString(R.string.dubai_al_satwa_ar));
            Neighborhood subFavorite21 = new Neighborhood(context.getResources().getString(R.string.dubai_al_shindagah),context.getResources().getString(R.string.dubai_al_shindagah_s),context.getResources().getString(R.string.dubai_al_shindagah_ar));
            Neighborhood subFavorite22 = new Neighborhood(context.getResources().getString(R.string.dubai_al_sufouh),context.getResources().getString(R.string.dubai_al_sufouh_s),context.getResources().getString(R.string.dubai_al_sufouh_ar));
            Neighborhood subFavorite23 = new Neighborhood(context.getResources().getString(R.string.dubai_al_twar),context.getResources().getString(R.string.dubai_al_twar_s),context.getResources().getString(R.string.dubai_al_twar_ar));
            Neighborhood subFavorite24 = new Neighborhood(context.getResources().getString(R.string.dubai_al_warqaa),context.getResources().getString(R.string.dubai_al_warqaa_s),context.getResources().getString(R.string.dubai_al_warqaa_ar));
            Neighborhood subFavorite25 = new Neighborhood(context.getResources().getString(R.string.dubai_al_warsan),context.getResources().getString(R.string.dubai_al_warsan_s),context.getResources().getString(R.string.dubai_al_warsan_ar));
            Neighborhood subFavorite26 = new Neighborhood(context.getResources().getString(R.string.dubai_al_wasl),context.getResources().getString(R.string.dubai_al_wasl_s),context.getResources().getString(R.string.dubai_al_wasl_ar));
            Neighborhood subFavorite27 = new Neighborhood(context.getResources().getString(R.string.dubai_arabian_ranches),context.getResources().getString(R.string.dubai_arabian_ranches_s),context.getResources().getString(R.string.dubai_arabian_ranches_ar));
            Neighborhood subFavorite28 = new Neighborhood(context.getResources().getString(R.string.dubai_bur_dubai),context.getResources().getString(R.string.dubai_bur_dubai_s),context.getResources().getString(R.string.dubai_bur_dubai_ar));
            Neighborhood subFavorite29 = new Neighborhood(context.getResources().getString(R.string.dubai_business_bay),context.getResources().getString(R.string.dubai_business_bay_s),context.getResources().getString(R.string.dubai_business_bay_ar));

            Neighborhood subFavorite30 = new Neighborhood(context.getResources().getString(R.string.dubai_culture_village),context.getResources().getString(R.string.dubai_culture_village_s),context.getResources().getString(R.string.dubai_culture_village_ar));
            Neighborhood subFavorite31 = new Neighborhood(context.getResources().getString(R.string.dubai_deira),context.getResources().getString(R.string.dubai_deira_s),context.getResources().getString(R.string.dubai_deira_ar));
            Neighborhood subFavorite32 = new Neighborhood(context.getResources().getString(R.string.dubai_difc),context.getResources().getString(R.string.dubai_difc_s),context.getResources().getString(R.string.dubai_difc_ar));
            Neighborhood subFavorite33 = new Neighborhood(context.getResources().getString(R.string.dubai_discovery_gardens),context.getResources().getString(R.string.dubai_discovery_gardens_s),context.getResources().getString(R.string.dubai_discovery_gardens_ar));
            Neighborhood subFavorite34 = new Neighborhood(context.getResources().getString(R.string.dubai_downtown_dubai),context.getResources().getString(R.string.dubai_downtown_dubai_s),context.getResources().getString(R.string.dubai_downtown_dubai_ar));
            Neighborhood subFavorite35 = new Neighborhood(context.getResources().getString(R.string.dubai_downtown_jebel_ali),context.getResources().getString(R.string.dubai_downtown_jebel_ali_s),context.getResources().getString(R.string.dubai_downtown_jebel_ali_ar));
            Neighborhood subFavorite36 = new Neighborhood(context.getResources().getString(R.string.dubai_design_district),context.getResources().getString(R.string.dubai_design_district_s),context.getResources().getString(R.string.dubai_design_district_ar));
            Neighborhood subFavorite37 = new Neighborhood(context.getResources().getString(R.string.dubai_festival_city),context.getResources().getString(R.string.dubai_festival_city_s),context.getResources().getString(R.string.dubai_festival_city_ar));
            Neighborhood subFavorite38 = new Neighborhood(context.getResources().getString(R.string.dubai_healthcare_city),context.getResources().getString(R.string.dubai_healthcare_city_s),context.getResources().getString(R.string.dubai_healthcare_city_ar));
            Neighborhood subFavorite39 = new Neighborhood(context.getResources().getString(R.string.dubai_hills_estate),context.getResources().getString(R.string.dubai_hills_estate_s),context.getResources().getString(R.string.dubai_hills_estate_ar));

            Neighborhood subFavorite40 = new Neighborhood(context.getResources().getString(R.string.dubai_industrial_city),context.getResources().getString(R.string.dubai_industrial_city_s),context.getResources().getString(R.string.dubai_industrial_city_ar));
            Neighborhood subFavorite41 = new Neighborhood(context.getResources().getString(R.string.dubai_international_city),context.getResources().getString(R.string.dubai_international_city_s),context.getResources().getString(R.string.dubai_international_city_ar));
            Neighborhood subFavorite42 = new Neighborhood(context.getResources().getString(R.string.dubai_investment_park),context.getResources().getString(R.string.dubai_investment_park_s),context.getResources().getString(R.string.dubai_investment_park_ar));
            Neighborhood subFavorite43 = new Neighborhood(context.getResources().getString(R.string.dubai_land),context.getResources().getString(R.string.dubai_land_s),context.getResources().getString(R.string.dubai_land_ar));
            Neighborhood subFavorite44 = new Neighborhood(context.getResources().getString(R.string.dubai_marina),context.getResources().getString(R.string.dubai_marina_s),context.getResources().getString(R.string.dubai_marina_ar));
            Neighborhood subFavorite45 = new Neighborhood(context.getResources().getString(R.string.dubai_media_city),context.getResources().getString(R.string.dubai_media_city_s),context.getResources().getString(R.string.dubai_media_city_ar));
            Neighborhood subFavorite46 = new Neighborhood(context.getResources().getString(R.string.dubai_pearl),context.getResources().getString(R.string.dubai_pearl_s),context.getResources().getString(R.string.dubai_pearl_ar));
            Neighborhood subFavorite47 = new Neighborhood(context.getResources().getString(R.string.dubai_promenade),context.getResources().getString(R.string.dubai_promenade_s),context.getResources().getString(R.string.dubai_promenade_ar));
            Neighborhood subFavorite48 = new Neighborhood(context.getResources().getString(R.string.dubai_silicon_oasis),context.getResources().getString(R.string.dubai_silicon_oasis_s),context.getResources().getString(R.string.dubai_silicon_oasis_ar));
            Neighborhood subFavorite49 = new Neighborhood(context.getResources().getString(R.string.dubai_sports_city),context.getResources().getString(R.string.dubai_sports_city_s),context.getResources().getString(R.string.dubai_sports_city_ar));

            Neighborhood subFavorite50 = new Neighborhood(context.getResources().getString(R.string.dubai_studio_city),context.getResources().getString(R.string.dubai_studio_city_s),context.getResources().getString(R.string.dubai_studio_city_ar));
            Neighborhood subFavorite51 = new Neighborhood(context.getResources().getString(R.string.dubai_waterfront),context.getResources().getString(R.string.dubai_waterfront_s),context.getResources().getString(R.string.dubai_waterfront_ar));
            Neighborhood subFavorite52 = new Neighborhood(context.getResources().getString(R.string.dubai_world_central),context.getResources().getString(R.string.dubai_world_central_s),context.getResources().getString(R.string.dubai_world_central_ar));
            Neighborhood subFavorite53 = new Neighborhood(context.getResources().getString(R.string.dubai_du_biotech),context.getResources().getString(R.string.dubai_du_biotech_s),context.getResources().getString(R.string.dubai_du_biotech_ar));
            Neighborhood subFavorite54 = new Neighborhood(context.getResources().getString(R.string.dubai_emirates_golf_club),context.getResources().getString(R.string.dubai_emirates_golf_club_s),context.getResources().getString(R.string.dubai_emirates_golf_club_ar));
            Neighborhood subFavorite55 = new Neighborhood(context.getResources().getString(R.string.dubai_emirates_hills),context.getResources().getString(R.string.dubai_emirates_hills_s),context.getResources().getString(R.string.dubai_emirates_hills_ar));
            Neighborhood subFavorite56 = new Neighborhood(context.getResources().getString(R.string.dubai_global_village),context.getResources().getString(R.string.dubai_global_village_s),context.getResources().getString(R.string.dubai_global_village_ar));
            Neighborhood subFavorite57 = new Neighborhood(context.getResources().getString(R.string.dubai_green_community),context.getResources().getString(R.string.dubai_green_community_s),context.getResources().getString(R.string.dubai_green_community_ar));
            Neighborhood subFavorite58 = new Neighborhood(context.getResources().getString(R.string.dubai_greens),context.getResources().getString(R.string.dubai_greens_s),context.getResources().getString(R.string.dubai_greens_ar));
            Neighborhood subFavorite59 = new Neighborhood(context.getResources().getString(R.string.dubai_hatta),context.getResources().getString(R.string.dubai_hatta_s),context.getResources().getString(R.string.dubai_hatta_ar));

            Neighborhood subFavorite60 = new Neighborhood(context.getResources().getString(R.string.dubai_impz),context.getResources().getString(R.string.dubai_impz_s),context.getResources().getString(R.string.dubai_impz_ar));
            Neighborhood subFavorite61 = new Neighborhood(context.getResources().getString(R.string.dubai_jebel_ali),context.getResources().getString(R.string.dubai_jebel_ali_s),context.getResources().getString(R.string.dubai_jebel_ali_ar));
            Neighborhood subFavorite62 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah),context.getResources().getString(R.string.dubai_jumeirah_s),context.getResources().getString(R.string.dubai_jumeirah_ar));
            Neighborhood subFavorite63 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_beach_residence),context.getResources().getString(R.string.dubai_jumeirah_beach_residence_s),context.getResources().getString(R.string.dubai_jumeirah_beach_residence_ar));
            Neighborhood subFavorite64 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_golf_estates),context.getResources().getString(R.string.dubai_jumeirah_golf_estates_s),context.getResources().getString(R.string.dubai_jumeirah_golf_estates_ar));
            Neighborhood subFavorite65 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_heights),context.getResources().getString(R.string.dubai_jumeirah_heights_s),context.getResources().getString(R.string.dubai_jumeirah_heights_ar));
            Neighborhood subFavorite66 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_islands),context.getResources().getString(R.string.dubai_jumeirah_islands_s),context.getResources().getString(R.string.dubai_jumeirah_islands_ar));
            Neighborhood subFavorite67 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_lake_towers),context.getResources().getString(R.string.dubai_jumeirah_lake_towers_s),context.getResources().getString(R.string.dubai_jumeirah_lake_towers_ar));
            Neighborhood subFavorite68 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_park),context.getResources().getString(R.string.dubai_jumeirah_park_s),context.getResources().getString(R.string.dubai_jumeirah_park_ar));
            Neighborhood subFavorite69 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_village_circle),context.getResources().getString(R.string.dubai_jumeirah_village_circle_s),context.getResources().getString(R.string.dubai_jumeirah_village_circle_ar));

            Neighborhood subFavorite70 = new Neighborhood(context.getResources().getString(R.string.dubai_jumeirah_village_triangle),context.getResources().getString(R.string.dubai_jumeirah_village_triangle_s),context.getResources().getString(R.string.dubai_jumeirah_village_triangle_ar));
            Neighborhood subFavorite71 = new Neighborhood(context.getResources().getString(R.string.dubai_karama),context.getResources().getString(R.string.dubai_karama_s),context.getResources().getString(R.string.dubai_karama_ar));
            Neighborhood subFavorite72 = new Neighborhood(context.getResources().getString(R.string.dubai_maritime_city),context.getResources().getString(R.string.dubai_maritime_city_s),context.getResources().getString(R.string.dubai_maritime_city_ar));
            Neighborhood subFavorite73 = new Neighborhood(context.getResources().getString(R.string.dubai_meadows),context.getResources().getString(R.string.dubai_meadows_s),context.getResources().getString(R.string.dubai_meadows_ar));
            Neighborhood subFavorite74 = new Neighborhood(context.getResources().getString(R.string.dubai_meydan_avenue),context.getResources().getString(R.string.dubai_meydan_avenue_s),context.getResources().getString(R.string.dubai_meydan_avenue_ar));
            Neighborhood subFavorite75 = new Neighborhood(context.getResources().getString(R.string.dubai_meydan_gated_community),context.getResources().getString(R.string.dubai_meydan_gated_community_s),context.getResources().getString(R.string.dubai_meydan_gated_community_ar));
            Neighborhood subFavorite76 = new Neighborhood(context.getResources().getString(R.string.dubai_mina_al_arab),context.getResources().getString(R.string.dubai_mina_al_arab_s),context.getResources().getString(R.string.dubai_mina_al_arab_ar));
            Neighborhood subFavorite77 = new Neighborhood(context.getResources().getString(R.string.dubai_mirdif),context.getResources().getString(R.string.dubai_mirdif_s),context.getResources().getString(R.string.dubai_mirdif_ar));
            Neighborhood subFavorite78 = new Neighborhood(context.getResources().getString(R.string.dubai_mohammad_bin_tashid_city),context.getResources().getString(R.string.dubai_mohammad_bin_tashid_city_s),context.getResources().getString(R.string.dubai_mohammad_bin_tashid_city_ar));
            Neighborhood subFavorite79 = new Neighborhood(context.getResources().getString(R.string.dubai_motor_city),context.getResources().getString(R.string.dubai_motor_city_s),context.getResources().getString(R.string.dubai_motor_city_ar));

            Neighborhood subFavorite80 = new Neighborhood(context.getResources().getString(R.string.dubai_motor_city),context.getResources().getString(R.string.dubai_motor_city_s),context.getResources().getString(R.string.dubai_motor_city_ar));
            Neighborhood subFavorite81 = new Neighborhood(context.getResources().getString(R.string.dubai_mushrif_park),context.getResources().getString(R.string.dubai_mushrif_park_s),context.getResources().getString(R.string.dubai_mushrif_park_ar));
            Neighborhood subFavorite82 = new Neighborhood(context.getResources().getString(R.string.dubai_nadd_al_hammar),context.getResources().getString(R.string.dubai_nadd_al_hammar_s),context.getResources().getString(R.string.dubai_nadd_al_hammar_ar));
            Neighborhood subFavorite83 = new Neighborhood(context.getResources().getString(R.string.dubai_nadd_al_sheba),context.getResources().getString(R.string.dubai_nadd_al_sheba_s),context.getResources().getString(R.string.dubai_nadd_al_sheba_ar));
            Neighborhood subFavorite84 = new Neighborhood(context.getResources().getString(R.string.dubai_old_town),context.getResources().getString(R.string.dubai_old_town_s),context.getResources().getString(R.string.dubai_old_town_ar));
            Neighborhood subFavorite85 = new Neighborhood(context.getResources().getString(R.string.dubai_oud_al_muteena),context.getResources().getString(R.string.dubai_oud_al_muteena_s),context.getResources().getString(R.string.dubai_oud_al_muteena_ar));
            Neighborhood subFavorite86 = new Neighborhood(context.getResources().getString(R.string.dubai_palm_jebel_ali),context.getResources().getString(R.string.dubai_palm_jebel_ali_s),context.getResources().getString(R.string.dubai_palm_jebel_ali_ar));
            Neighborhood subFavorite87 = new Neighborhood(context.getResources().getString(R.string.dubai_palm_jumeirah),context.getResources().getString(R.string.dubai_palm_jumeirah_s),context.getResources().getString(R.string.dubai_palm_jumeirah_ar));
            Neighborhood subFavorite88 = new Neighborhood(context.getResources().getString(R.string.dubai_ras_al_khor),context.getResources().getString(R.string.dubai_ras_al_khor_s),context.getResources().getString(R.string.dubai_ras_al_khor_ar));
            Neighborhood subFavorite89 = new Neighborhood(context.getResources().getString(R.string.dubai_reem),context.getResources().getString(R.string.dubai_reem_s),context.getResources().getString(R.string.dubai_reem_ar));

            Neighborhood subFavorite90 = new Neighborhood(context.getResources().getString(R.string.dubai_sheikh_zayed_road),context.getResources().getString(R.string.dubai_sheikh_zayed_road_s),context.getResources().getString(R.string.dubai_sheikh_zayed_road_ar));
            Neighborhood subFavorite91 = new Neighborhood(context.getResources().getString(R.string.dubai_technology_park),context.getResources().getString(R.string.dubai_technology_park_s),context.getResources().getString(R.string.dubai_technology_park_ar));
            Neighborhood subFavorite92 = new Neighborhood(context.getResources().getString(R.string.dubai_tecom),context.getResources().getString(R.string.dubai_tecom_s),context.getResources().getString(R.string.dubai_tecom_ar));
            Neighborhood subFavorite93 = new Neighborhood(context.getResources().getString(R.string.dubai_the_gardens),context.getResources().getString(R.string.dubai_the_gardens_s),context.getResources().getString(R.string.dubai_the_gardens_ar));
            Neighborhood subFavorite94 = new Neighborhood(context.getResources().getString(R.string.dubai_the_hills),context.getResources().getString(R.string.dubai_the_hills_s),context.getResources().getString(R.string.dubai_the_hills_ar));
            Neighborhood subFavorite95 = new Neighborhood(context.getResources().getString(R.string.dubai_the_lagoons),context.getResources().getString(R.string.dubai_the_lagoons_s),context.getResources().getString(R.string.dubai_the_lagoons_ar));
            Neighborhood subFavorite96 = new Neighborhood(context.getResources().getString(R.string.dubai_the_lakes),context.getResources().getString(R.string.dubai_the_lakes_s),context.getResources().getString(R.string.dubai_the_lakes_ar));
            Neighborhood subFavorite97 = new Neighborhood(context.getResources().getString(R.string.dubai_the_meadows),context.getResources().getString(R.string.dubai_the_meadows_s),context.getResources().getString(R.string.dubai_the_meadows_ar));
            Neighborhood subFavorite98 = new Neighborhood(context.getResources().getString(R.string.dubai_the_palm_deira),context.getResources().getString(R.string.dubai_the_palm_deira_s),context.getResources().getString(R.string.dubai_the_palm_deira_ar));
            Neighborhood subFavorite99 = new Neighborhood(context.getResources().getString(R.string.dubai_the_springs),context.getResources().getString(R.string.dubai_the_springs_s),context.getResources().getString(R.string.dubai_the_springs_ar));

            Neighborhood subFavorite100 = new Neighborhood(context.getResources().getString(R.string.dubai_the_views),context.getResources().getString(R.string.dubai_the_views_s),context.getResources().getString(R.string.dubai_the_views_ar));
            Neighborhood subFavorite101 = new Neighborhood(context.getResources().getString(R.string.dubai_the_world_islands),context.getResources().getString(R.string.dubai_the_world_islands_s),context.getResources().getString(R.string.dubai_the_world_islands_ar));
            Neighborhood subFavorite102 = new Neighborhood(context.getResources().getString(R.string.dubai_umm_al_sheif),context.getResources().getString(R.string.dubai_umm_al_sheif_s),context.getResources().getString(R.string.dubai_umm_al_sheif_ar));
            Neighborhood subFavorite103 = new Neighborhood(context.getResources().getString(R.string.dubai_umm_hurair),context.getResources().getString(R.string.dubai_umm_hurair_s),context.getResources().getString(R.string.dubai_umm_hurair_ar));
            Neighborhood subFavorite104 = new Neighborhood(context.getResources().getString(R.string.dubai_umm_ramool),context.getResources().getString(R.string.dubai_umm_ramool_s),context.getResources().getString(R.string.dubai_umm_ramool_ar));
            Neighborhood subFavorite105 = new Neighborhood(context.getResources().getString(R.string.dubai_umm_suqeim),context.getResources().getString(R.string.dubai_umm_suqeim_s),context.getResources().getString(R.string.dubai_umm_suqeim_ar));
            Neighborhood subFavorite106 = new Neighborhood(context.getResources().getString(R.string.dubai_victory_heights),context.getResources().getString(R.string.dubai_victory_heights_s),context.getResources().getString(R.string.dubai_victory_heights_ar));
            Neighborhood subFavorite107 = new Neighborhood(context.getResources().getString(R.string.dubai_wadi_al_amardi),context.getResources().getString(R.string.dubai_wadi_al_amardi_s),context.getResources().getString(R.string.dubai_wadi_al_amardi_ar));
            Neighborhood subFavorite108 = new Neighborhood(context.getResources().getString(R.string.dubai_world_trade_center),context.getResources().getString(R.string.dubai_world_trade_center_s),context.getResources().getString(R.string.dubai_world_trade_center_ar));
            Neighborhood subFavorite109 = new Neighborhood(context.getResources().getString(R.string.dubai_zabeel),context.getResources().getString(R.string.dubai_zabeel_s),context.getResources().getString(R.string.dubai_zabeel_ar));

            Neighborhood subFavorite110 = new Neighborhood(context.getResources().getString(R.string.dubai_zulal),context.getResources().getString(R.string.dubai_zulal_s),context.getResources().getString(R.string.dubai_zulal_ar));
            Neighborhood subFavorite111 = new Neighborhood(context.getResources().getString(R.string.dubai_al_badaa),context.getResources().getString(R.string.dubai_al_badaa_s),context.getResources().getString(R.string.dubai_al_badaa_ar));
            Neighborhood subFavorite112 = new Neighborhood(context.getResources().getString(R.string.dubai_al_nahda),context.getResources().getString(R.string.dubai_al_nahda_s),context.getResources().getString(R.string.dubai_al_nahda_ar));
            Neighborhood subFavorite113 = new Neighborhood(context.getResources().getString(R.string.dubai_al_rashidiya),context.getResources().getString(R.string.dubai_al_rashidiya_s),context.getResources().getString(R.string.dubai_al_rashidiya_ar));
            Neighborhood subFavorite114 = new Neighborhood(context.getResources().getString(R.string.dubai_south_dubai),context.getResources().getString(R.string.dubai_south_dubai_s),context.getResources().getString(R.string.dubai_south_dubai_ar));
            Neighborhood subFavorite115 = new Neighborhood(context.getResources().getString(R.string.dubai_damac_hills),context.getResources().getString(R.string.dubai_damac_hills_s),context.getResources().getString(R.string.dubai_damac_hills_ar));
            Neighborhood subFavorite116 = new Neighborhood(context.getResources().getString(R.string.dubai_bluewaters_island),context.getResources().getString(R.string.dubai_bluewaters_island_s),context.getResources().getString(R.string.dubai_bluewaters_island_ar));
            Neighborhood subFavorite117 = new Neighborhood(context.getResources().getString(R.string.dubai_mudon),context.getResources().getString(R.string.dubai_mudon_s),context.getResources().getString(R.string.dubai_mudon_ar));
            Neighborhood subFavorite118 = new Neighborhood(context.getResources().getString(R.string.dubai_liwan),context.getResources().getString(R.string.dubai_liwan_s),context.getResources().getString(R.string.dubai_liwan_ar));
            Neighborhood subFavorite119 = new Neighborhood(context.getResources().getString(R.string.dubai_serena),context.getResources().getString(R.string.dubai_serena_s),context.getResources().getString(R.string.dubai_serena_ar));

            Neighborhood subFavorite120 = new Neighborhood(context.getResources().getString(R.string.dubai_port_rashid),context.getResources().getString(R.string.dubai_port_rashid_s),context.getResources().getString(R.string.dubai_port_rashid_ar));
            Neighborhood subFavorite121 = new Neighborhood(context.getResources().getString(R.string.dubai_remram),context.getResources().getString(R.string.dubai_remram_s),context.getResources().getString(R.string.dubai_remram_ar));
            Neighborhood subFavorite122 = new Neighborhood(context.getResources().getString(R.string.dubai_sceince_park),context.getResources().getString(R.string.dubai_sceince_park_s),context.getResources().getString(R.string.dubai_sceince_park_ar));
            Neighborhood subFavorite123 = new Neighborhood(context.getResources().getString(R.string.dubai_residence_complex),context.getResources().getString(R.string.dubai_residence_complex_s),context.getResources().getString(R.string.dubai_residence_complex_ar));
            Neighborhood subFavorite124 = new Neighborhood(context.getResources().getString(R.string.dubai_al_manara),context.getResources().getString(R.string.dubai_al_manara_s),context.getResources().getString(R.string.dubai_al_manara_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);
            neighborhoodArrayL.add(subFavorite12);
            neighborhoodArrayL.add(subFavorite13);
            neighborhoodArrayL.add(subFavorite14);
            neighborhoodArrayL.add(subFavorite15);
            neighborhoodArrayL.add(subFavorite16);
            neighborhoodArrayL.add(subFavorite17);
            neighborhoodArrayL.add(subFavorite18);
            neighborhoodArrayL.add(subFavorite19);

            neighborhoodArrayL.add(subFavorite20);
            neighborhoodArrayL.add(subFavorite21);
            neighborhoodArrayL.add(subFavorite22);
            neighborhoodArrayL.add(subFavorite23);
            neighborhoodArrayL.add(subFavorite24);
            neighborhoodArrayL.add(subFavorite25);
            neighborhoodArrayL.add(subFavorite26);
            neighborhoodArrayL.add(subFavorite27);
            neighborhoodArrayL.add(subFavorite28);
            neighborhoodArrayL.add(subFavorite29);

            neighborhoodArrayL.add(subFavorite30);
            neighborhoodArrayL.add(subFavorite31);
            neighborhoodArrayL.add(subFavorite32);
            neighborhoodArrayL.add(subFavorite33);
            neighborhoodArrayL.add(subFavorite34);
            neighborhoodArrayL.add(subFavorite35);
            neighborhoodArrayL.add(subFavorite36);
            neighborhoodArrayL.add(subFavorite37);
            neighborhoodArrayL.add(subFavorite38);
            neighborhoodArrayL.add(subFavorite39);

            neighborhoodArrayL.add(subFavorite40);
            neighborhoodArrayL.add(subFavorite41);
            neighborhoodArrayL.add(subFavorite42);
            neighborhoodArrayL.add(subFavorite43);
            neighborhoodArrayL.add(subFavorite44);
            neighborhoodArrayL.add(subFavorite45);
            neighborhoodArrayL.add(subFavorite46);
            neighborhoodArrayL.add(subFavorite47);
            neighborhoodArrayL.add(subFavorite48);
            neighborhoodArrayL.add(subFavorite49);

            neighborhoodArrayL.add(subFavorite50);
            neighborhoodArrayL.add(subFavorite51);
            neighborhoodArrayL.add(subFavorite52);
            neighborhoodArrayL.add(subFavorite53);
            neighborhoodArrayL.add(subFavorite54);
            neighborhoodArrayL.add(subFavorite55);
            neighborhoodArrayL.add(subFavorite56);
            neighborhoodArrayL.add(subFavorite57);
            neighborhoodArrayL.add(subFavorite58);
            neighborhoodArrayL.add(subFavorite59);

            neighborhoodArrayL.add(subFavorite60);
            neighborhoodArrayL.add(subFavorite61);
            neighborhoodArrayL.add(subFavorite62);
            neighborhoodArrayL.add(subFavorite63);
            neighborhoodArrayL.add(subFavorite64);
            neighborhoodArrayL.add(subFavorite65);
            neighborhoodArrayL.add(subFavorite66);
            neighborhoodArrayL.add(subFavorite67);
            neighborhoodArrayL.add(subFavorite68);
            neighborhoodArrayL.add(subFavorite69);

            neighborhoodArrayL.add(subFavorite70);
            neighborhoodArrayL.add(subFavorite71);
            neighborhoodArrayL.add(subFavorite72);
            neighborhoodArrayL.add(subFavorite73);
            neighborhoodArrayL.add(subFavorite74);
            neighborhoodArrayL.add(subFavorite75);
            neighborhoodArrayL.add(subFavorite76);
            neighborhoodArrayL.add(subFavorite77);
            neighborhoodArrayL.add(subFavorite78);
            neighborhoodArrayL.add(subFavorite79);

            neighborhoodArrayL.add(subFavorite80);
            neighborhoodArrayL.add(subFavorite81);
            neighborhoodArrayL.add(subFavorite82);
            neighborhoodArrayL.add(subFavorite83);
            neighborhoodArrayL.add(subFavorite84);
            neighborhoodArrayL.add(subFavorite85);
            neighborhoodArrayL.add(subFavorite86);
            neighborhoodArrayL.add(subFavorite87);
            neighborhoodArrayL.add(subFavorite88);
            neighborhoodArrayL.add(subFavorite89);

            neighborhoodArrayL.add(subFavorite90);
            neighborhoodArrayL.add(subFavorite91);
            neighborhoodArrayL.add(subFavorite92);
            neighborhoodArrayL.add(subFavorite93);
            neighborhoodArrayL.add(subFavorite94);
            neighborhoodArrayL.add(subFavorite95);
            neighborhoodArrayL.add(subFavorite96);
            neighborhoodArrayL.add(subFavorite97);
            neighborhoodArrayL.add(subFavorite98);
            neighborhoodArrayL.add(subFavorite99);

            neighborhoodArrayL.add(subFavorite100);
            neighborhoodArrayL.add(subFavorite101);
            neighborhoodArrayL.add(subFavorite102);
            neighborhoodArrayL.add(subFavorite103);
            neighborhoodArrayL.add(subFavorite104);
            neighborhoodArrayL.add(subFavorite105);
            neighborhoodArrayL.add(subFavorite106);
            neighborhoodArrayL.add(subFavorite107);
            neighborhoodArrayL.add(subFavorite108);
            neighborhoodArrayL.add(subFavorite109);

            neighborhoodArrayL.add(subFavorite110);
            neighborhoodArrayL.add(subFavorite111);
            neighborhoodArrayL.add(subFavorite112);
            neighborhoodArrayL.add(subFavorite113);
            neighborhoodArrayL.add(subFavorite114);
            neighborhoodArrayL.add(subFavorite115);
            neighborhoodArrayL.add(subFavorite116);
            neighborhoodArrayL.add(subFavorite117);
            neighborhoodArrayL.add(subFavorite118);
            neighborhoodArrayL.add(subFavorite119);

            neighborhoodArrayL.add(subFavorite120);
            neighborhoodArrayL.add(subFavorite121);
            neighborhoodArrayL.add(subFavorite122);
            neighborhoodArrayL.add(subFavorite123);
            neighborhoodArrayL.add(subFavorite124);

//            neighborhoodArrayL.add(subFavorite130);

        }

        if (city.equals(context.getResources().getString(R.string.abu_dhabi)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_gate_city),context.getResources().getString(R.string.abu_dhabi_gate_city_s),context.getResources().getString(R.string.abu_dhabi_gate_city_ar));
            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_airport),context.getResources().getString(R.string.abu_dhabi_airport_s),context.getResources().getString(R.string.abu_dhabi_airport_ar));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_badaa),context.getResources().getString(R.string.abu_dhabi_al_badaa_s),context.getResources().getString(R.string.abu_dhabi_al_badaa_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_bahia),context.getResources().getString(R.string.abu_dhabi_al_bahia_s),context.getResources().getString(R.string.abu_dhabi_al_bahia_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_baraha),context.getResources().getString(R.string.abu_dhabi_al_baraha_s),context.getResources().getString(R.string.abu_dhabi_al_baraha_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_bateen),context.getResources().getString(R.string.abu_dhabi_al_bateen_s),context.getResources().getString(R.string.abu_dhabi_al_bateen_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_dhafrah),context.getResources().getString(R.string.abu_dhabi_al_dhafrah_s),context.getResources().getString(R.string.abu_dhabi_al_dhafrah_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_falah_city),context.getResources().getString(R.string.abu_dhabi_al_falah_city_s),context.getResources().getString(R.string.abu_dhabi_al_falah_city_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_forsan),context.getResources().getString(R.string.abu_dhabi_al_forsan_s),context.getResources().getString(R.string.abu_dhabi_al_forsan_ar));

            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_ghadeer),context.getResources().getString(R.string.abu_dhabi_al_ghadeer_s),context.getResources().getString(R.string.abu_dhabi_al_ghadeer_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_gurm),context.getResources().getString(R.string.abu_dhabi_al_gurm_s),context.getResources().getString(R.string.abu_dhabi_al_gurm_ar));
            Neighborhood subFavorite12 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_gurm_west),context.getResources().getString(R.string.abu_dhabi_al_gurm_west_s),context.getResources().getString(R.string.abu_dhabi_al_gurm_west_ar));
            Neighborhood subFavorite13 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_hudayriat_island),context.getResources().getString(R.string.abu_dhabi_al_hudayriat_island_s),context.getResources().getString(R.string.abu_dhabi_al_hudayriat_island_ar));
            Neighborhood subFavorite14 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_ittihad_road),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_s),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_ar));
            Neighborhood subFavorite15 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_karama),context.getResources().getString(R.string.abu_dhabi_al_karama_s),context.getResources().getString(R.string.abu_dhabi_al_karama_ar));
            Neighborhood subFavorite16 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_khalidiya),context.getResources().getString(R.string.abu_dhabi_al_khalidiya_s),context.getResources().getString(R.string.abu_dhabi_al_khalidiya_ar));
            Neighborhood subFavorite17 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_khatim),context.getResources().getString(R.string.abu_dhabi_al_khatim_s),context.getResources().getString(R.string.abu_dhabi_al_khatim_ar));
            Neighborhood subFavorite18 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_maffraq),context.getResources().getString(R.string.abu_dhabi_al_maffraq_s),context.getResources().getString(R.string.abu_dhabi_al_maffraq_ar));
            Neighborhood subFavorite19 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_manaseer),context.getResources().getString(R.string.abu_dhabi_al_manaseer_s),context.getResources().getString(R.string.abu_dhabi_al_manaseer_ar));

            Neighborhood subFavorite20 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_manhal),context.getResources().getString(R.string.abu_dhabi_al_manhal_s),context.getResources().getString(R.string.abu_dhabi_al_manhal_ar));
            Neighborhood subFavorite21 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_maqtaa),context.getResources().getString(R.string.abu_dhabi_al_maqtaa_s),context.getResources().getString(R.string.abu_dhabi_al_maqtaa_ar));
            Neighborhood subFavorite22 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_markaziyah),context.getResources().getString(R.string.abu_dhabi_al_markaziyah_s),context.getResources().getString(R.string.abu_dhabi_al_markaziyah_ar));
            Neighborhood subFavorite23 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_maryah),context.getResources().getString(R.string.abu_dhabi_al_maryah_s),context.getResources().getString(R.string.abu_dhabi_al_maryah_ar));
            Neighborhood subFavorite24 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_mina),context.getResources().getString(R.string.abu_dhabi_al_mina_s),context.getResources().getString(R.string.abu_dhabi_al_mina_ar));
            Neighborhood subFavorite25 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_mushrif),context.getResources().getString(R.string.abu_dhabi_al_mushrif_s),context.getResources().getString(R.string.abu_dhabi_al_mushrif_ar));
            Neighborhood subFavorite26 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_nahda),context.getResources().getString(R.string.abu_dhabi_al_nahda_s),context.getResources().getString(R.string.abu_dhabi_al_nahda_ar));
            Neighborhood subFavorite27 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_nahyan_camp),context.getResources().getString(R.string.abu_dhabi_al_nahyan_camp_s),context.getResources().getString(R.string.abu_dhabi_al_nahyan_camp_ar));
            Neighborhood subFavorite28 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_najda_street),context.getResources().getString(R.string.abu_dhabi_al_najda_street_s),context.getResources().getString(R.string.abu_dhabi_al_najda_street_ar));
            Neighborhood subFavorite29 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_raha_beach),context.getResources().getString(R.string.abu_dhabi_al_raha_beach_s),context.getResources().getString(R.string.abu_dhabi_al_raha_beach_ar));

            Neighborhood subFavorite30 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_raha_gardens),context.getResources().getString(R.string.abu_dhabi_al_raha_gardens_s),context.getResources().getString(R.string.abu_dhabi_al_raha_gardens_ar));
            Neighborhood subFavorite31 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_raha_golf_gardens),context.getResources().getString(R.string.abu_dhabi_al_raha_golf_gardens_s),context.getResources().getString(R.string.abu_dhabi_al_raha_golf_gardens_ar));
            Neighborhood subFavorite32 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_rahba),context.getResources().getString(R.string.abu_dhabi_al_rahba_s),context.getResources().getString(R.string.abu_dhabi_al_rahba_ar));
            Neighborhood subFavorite33 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_rawdah),context.getResources().getString(R.string.abu_dhabi_al_rawdah_s),context.getResources().getString(R.string.abu_dhabi_al_rawdah_ar));
            Neighborhood subFavorite34 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_rayhan),context.getResources().getString(R.string.abu_dhabi_al_rayhan_s),context.getResources().getString(R.string.abu_dhabi_al_rayhan_ar));
            Neighborhood subFavorite35 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_reef),context.getResources().getString(R.string.abu_dhabi_al_reef_s),context.getResources().getString(R.string.abu_dhabi_al_reef_ar));
            Neighborhood subFavorite36 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_reem_island),context.getResources().getString(R.string.abu_dhabi_al_reem_island_s),context.getResources().getString(R.string.abu_dhabi_al_reem_island_ar));
            Neighborhood subFavorite37 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_ruwais),context.getResources().getString(R.string.abu_dhabi_al_ruwais_s),context.getResources().getString(R.string.abu_dhabi_al_ruwais_ar));
            Neighborhood subFavorite38 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_salam_street),context.getResources().getString(R.string.abu_dhabi_al_salam_street_s),context.getResources().getString(R.string.abu_dhabi_al_salam_street_ar));
            Neighborhood subFavorite39 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_samha),context.getResources().getString(R.string.abu_dhabi_al_samha_s),context.getResources().getString(R.string.abu_dhabi_al_samha_ar));

            Neighborhood subFavorite40 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_shahama),context.getResources().getString(R.string.abu_dhabi_al_shahama_s),context.getResources().getString(R.string.abu_dhabi_al_shahama_ar));
            Neighborhood subFavorite41 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_shamkha),context.getResources().getString(R.string.abu_dhabi_al_shamkha_s),context.getResources().getString(R.string.abu_dhabi_al_shamkha_ar));
            Neighborhood subFavorite42 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_shawamekh),context.getResources().getString(R.string.abu_dhabi_al_shawamekh_s),context.getResources().getString(R.string.abu_dhabi_al_shawamekh_ar));
            Neighborhood subFavorite43 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_silaa),context.getResources().getString(R.string.abu_dhabi_al_silaa_s),context.getResources().getString(R.string.abu_dhabi_al_silaa_ar));
            Neighborhood subFavorite44 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_wahda),context.getResources().getString(R.string.abu_dhabi_al_wahda_s),context.getResources().getString(R.string.abu_dhabi_al_wahda_ar));
            Neighborhood subFavorite45 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_wathba),context.getResources().getString(R.string.abu_dhabi_al_wathba_s),context.getResources().getString(R.string.abu_dhabi_al_wathba_ar));
            Neighborhood subFavorite46 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_zaab),context.getResources().getString(R.string.abu_dhabi_al_zaab_s),context.getResources().getString(R.string.abu_dhabi_al_zaab_ar));
            Neighborhood subFavorite47 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_zahraa),context.getResources().getString(R.string.abu_dhabi_al_zahraa_s),context.getResources().getString(R.string.abu_dhabi_al_zahraa_ar));
            Neighborhood subFavorite48 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_baniyas),context.getResources().getString(R.string.abu_dhabi_al_baniyas_s),context.getResources().getString(R.string.abu_dhabi_al_baniyas_ar));
            Neighborhood subFavorite49 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_between_tow_bridges),context.getResources().getString(R.string.abu_dhabi_between_tow_bridges_s),context.getResources().getString(R.string.abu_dhabi_between_tow_bridges_ar));

            Neighborhood subFavorite50 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_building_materials_city),context.getResources().getString(R.string.abu_dhabi_building_materials_city_s),context.getResources().getString(R.string.abu_dhabi_building_materials_city_ar));
            Neighborhood subFavorite51 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_capital_centre),context.getResources().getString(R.string.abu_dhabi_capital_centre_s),context.getResources().getString(R.string.abu_dhabi_capital_centre_ar));
            Neighborhood subFavorite52 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_city_downtown),context.getResources().getString(R.string.abu_dhabi_city_downtown_s),context.getResources().getString(R.string.abu_dhabi_city_downtown_ar));
            Neighborhood subFavorite53 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_corniche_area),context.getResources().getString(R.string.abu_dhabi_corniche_area_s),context.getResources().getString(R.string.abu_dhabi_corniche_area_ar));
            Neighborhood subFavorite54 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_corniche_road),context.getResources().getString(R.string.abu_dhabi_corniche_road_s),context.getResources().getString(R.string.abu_dhabi_corniche_road_ar));
            Neighborhood subFavorite55 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_ar));
            Neighborhood subFavorite56 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_ar));
            Neighborhood subFavorite57 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_defence_street),context.getResources().getString(R.string.abu_dhabi_defence_street_s),context.getResources().getString(R.string.abu_dhabi_defence_street_ar));
            Neighborhood subFavorite58 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_desert_village),context.getResources().getString(R.string.abu_dhabi_desert_village_s),context.getResources().getString(R.string.abu_dhabi_desert_village_ar));
            Neighborhood subFavorite59 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_eastern_road),context.getResources().getString(R.string.abu_dhabi_eastern_road_s),context.getResources().getString(R.string.abu_dhabi_eastern_road_ar));

            Neighborhood subFavorite60 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_electra_street),context.getResources().getString(R.string.abu_dhabi_electra_street_s),context.getResources().getString(R.string.abu_dhabi_electra_street_ar));
            Neighborhood subFavorite61 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_ghantoot),context.getResources().getString(R.string.abu_dhabi_ghantoot_s),context.getResources().getString(R.string.abu_dhabi_ghantoot_ar));
            Neighborhood subFavorite62 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_grand_mosque_district),context.getResources().getString(R.string.abu_dhabi_grand_mosque_district_s),context.getResources().getString(R.string.abu_dhabi_grand_mosque_district_ar));
            Neighborhood subFavorite63 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_hamdan_street),context.getResources().getString(R.string.abu_dhabi_hamdan_street_s),context.getResources().getString(R.string.abu_dhabi_hamdan_street_ar));
            Neighborhood subFavorite64 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_hameem),context.getResources().getString(R.string.abu_dhabi_hameem_s),context.getResources().getString(R.string.abu_dhabi_hameem_ar));
            Neighborhood subFavorite65 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_hydra_village),context.getResources().getString(R.string.abu_dhabi_hydra_village_s),context.getResources().getString(R.string.abu_dhabi_hydra_village_ar));
            Neighborhood subFavorite66 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_jawazat_street),context.getResources().getString(R.string.abu_dhabi_jawazat_street_s),context.getResources().getString(R.string.abu_dhabi_jawazat_street_ar));
            Neighborhood subFavorite67 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_khalifa_city),context.getResources().getString(R.string.abu_dhabi_khalifa_city_s),context.getResources().getString(R.string.abu_dhabi_khalifa_city_ar));
            Neighborhood subFavorite68 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_khalifa_street),context.getResources().getString(R.string.abu_dhabi_khalifa_street_s),context.getResources().getString(R.string.abu_dhabi_khalifa_street_ar));
            Neighborhood subFavorite69 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_liwa),context.getResources().getString(R.string.abu_dhabi_liwa_s),context.getResources().getString(R.string.abu_dhabi_liwa_ar));

            Neighborhood subFavorite70 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_lulu_island),context.getResources().getString(R.string.abu_dhabi_lulu_island_s),context.getResources().getString(R.string.abu_dhabi_lulu_island_ar));
            Neighborhood subFavorite71 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_madinat_zayed),context.getResources().getString(R.string.abu_dhabi_madinat_zayed_s),context.getResources().getString(R.string.abu_dhabi_madinat_zayed_ar));
            Neighborhood subFavorite72 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_marina_village),context.getResources().getString(R.string.abu_dhabi_marina_village_s),context.getResources().getString(R.string.abu_dhabi_marina_village_ar));
            Neighborhood subFavorite73 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_masdar_city),context.getResources().getString(R.string.abu_dhabi_masdar_city_s),context.getResources().getString(R.string.abu_dhabi_masdar_city_ar));
            Neighborhood subFavorite74 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_mina_zayed),context.getResources().getString(R.string.abu_dhabi_mina_zayed_s),context.getResources().getString(R.string.abu_dhabi_mina_zayed_ar));
            Neighborhood subFavorite75 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_mohammad_bin_zayed_city),context.getResources().getString(R.string.abu_dhabi_mohammad_bin_zayed_city_s),context.getResources().getString(R.string.abu_dhabi_mohammad_bin_zayed_city_ar));
            Neighborhood subFavorite76 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_muroor_area),context.getResources().getString(R.string.abu_dhabi_muroor_area_s),context.getResources().getString(R.string.abu_dhabi_muroor_area_ar));
            Neighborhood subFavorite77 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_mussafah),context.getResources().getString(R.string.abu_dhabi_mussafah_s),context.getResources().getString(R.string.abu_dhabi_mussafah_ar));
            Neighborhood subFavorite78 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_nurai_island),context.getResources().getString(R.string.abu_dhabi_nurai_island_s),context.getResources().getString(R.string.abu_dhabi_nurai_island_ar));
            Neighborhood subFavorite79 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_saadiyat_island),context.getResources().getString(R.string.abu_dhabi_saadiyat_island_s),context.getResources().getString(R.string.abu_dhabi_saadiyat_island_ar));

            Neighborhood subFavorite80 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_sas_al_nakheel),context.getResources().getString(R.string.abu_dhabi_sas_al_nakheel_s),context.getResources().getString(R.string.abu_dhabi_sas_al_nakheel_ar));
            Neighborhood subFavorite81 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_tourist_club_area),context.getResources().getString(R.string.abu_dhabi_tourist_club_area_s),context.getResources().getString(R.string.abu_dhabi_tourist_club_area_ar));
            Neighborhood subFavorite82 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_umm_al_nar),context.getResources().getString(R.string.abu_dhabi_umm_al_nar_s),context.getResources().getString(R.string.abu_dhabi_umm_al_nar_ar));
            Neighborhood subFavorite83 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_yas_island),context.getResources().getString(R.string.abu_dhabi_yas_island_s),context.getResources().getString(R.string.abu_dhabi_yas_island_ar));
            Neighborhood subFavorite84 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_zayed_military_city),context.getResources().getString(R.string.abu_dhabi_zayed_military_city_s),context.getResources().getString(R.string.abu_dhabi_zayed_military_city_ar));
            Neighborhood subFavorite85 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_zayed_sports_city),context.getResources().getString(R.string.abu_dhabi_zayed_sports_city_s),context.getResources().getString(R.string.abu_dhabi_zayed_sports_city_ar));
            Neighborhood subFavorite86 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_badaa),context.getResources().getString(R.string.abu_dhabi_al_badaa_s),context.getResources().getString(R.string.abu_dhabi_al_badaa_ar));
            Neighborhood subFavorite87 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_ittihad_road),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_s),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_ar));
            Neighborhood subFavorite88 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_city_downtown),context.getResources().getString(R.string.abu_dhabi_city_downtown_s),context.getResources().getString(R.string.abu_dhabi_city_downtown_ar));
            Neighborhood subFavorite89 = new Neighborhood(context.getResources().getString(R.string.abu_dhabi_al_forsan),context.getResources().getString(R.string.abu_dhabi_al_forsan_s),context.getResources().getString(R.string.abu_dhabi_al_forsan_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);
            neighborhoodArrayL.add(subFavorite12);
            neighborhoodArrayL.add(subFavorite13);
            neighborhoodArrayL.add(subFavorite14);
            neighborhoodArrayL.add(subFavorite15);
            neighborhoodArrayL.add(subFavorite16);
            neighborhoodArrayL.add(subFavorite17);
            neighborhoodArrayL.add(subFavorite18);
            neighborhoodArrayL.add(subFavorite19);

            neighborhoodArrayL.add(subFavorite20);
            neighborhoodArrayL.add(subFavorite21);
            neighborhoodArrayL.add(subFavorite22);
            neighborhoodArrayL.add(subFavorite23);
            neighborhoodArrayL.add(subFavorite24);
            neighborhoodArrayL.add(subFavorite25);
            neighborhoodArrayL.add(subFavorite26);
            neighborhoodArrayL.add(subFavorite27);
            neighborhoodArrayL.add(subFavorite28);
            neighborhoodArrayL.add(subFavorite29);

            neighborhoodArrayL.add(subFavorite30);
            neighborhoodArrayL.add(subFavorite31);
            neighborhoodArrayL.add(subFavorite32);
            neighborhoodArrayL.add(subFavorite33);
            neighborhoodArrayL.add(subFavorite34);
            neighborhoodArrayL.add(subFavorite35);
            neighborhoodArrayL.add(subFavorite36);
            neighborhoodArrayL.add(subFavorite37);
            neighborhoodArrayL.add(subFavorite38);
            neighborhoodArrayL.add(subFavorite39);

            neighborhoodArrayL.add(subFavorite40);
            neighborhoodArrayL.add(subFavorite41);
            neighborhoodArrayL.add(subFavorite42);
            neighborhoodArrayL.add(subFavorite43);
            neighborhoodArrayL.add(subFavorite44);
            neighborhoodArrayL.add(subFavorite45);
            neighborhoodArrayL.add(subFavorite46);
            neighborhoodArrayL.add(subFavorite47);
            neighborhoodArrayL.add(subFavorite48);
            neighborhoodArrayL.add(subFavorite49);

            neighborhoodArrayL.add(subFavorite50);
            neighborhoodArrayL.add(subFavorite51);
            neighborhoodArrayL.add(subFavorite52);
            neighborhoodArrayL.add(subFavorite53);
            neighborhoodArrayL.add(subFavorite54);
            neighborhoodArrayL.add(subFavorite55);
            neighborhoodArrayL.add(subFavorite56);
            neighborhoodArrayL.add(subFavorite57);
            neighborhoodArrayL.add(subFavorite58);
            neighborhoodArrayL.add(subFavorite59);

            neighborhoodArrayL.add(subFavorite60);
            neighborhoodArrayL.add(subFavorite61);
            neighborhoodArrayL.add(subFavorite62);
            neighborhoodArrayL.add(subFavorite63);
            neighborhoodArrayL.add(subFavorite64);
            neighborhoodArrayL.add(subFavorite65);
            neighborhoodArrayL.add(subFavorite66);
            neighborhoodArrayL.add(subFavorite67);
            neighborhoodArrayL.add(subFavorite68);
            neighborhoodArrayL.add(subFavorite69);

            neighborhoodArrayL.add(subFavorite70);
            neighborhoodArrayL.add(subFavorite71);
            neighborhoodArrayL.add(subFavorite72);
            neighborhoodArrayL.add(subFavorite73);
            neighborhoodArrayL.add(subFavorite74);
            neighborhoodArrayL.add(subFavorite75);
            neighborhoodArrayL.add(subFavorite76);
            neighborhoodArrayL.add(subFavorite77);
            neighborhoodArrayL.add(subFavorite78);
            neighborhoodArrayL.add(subFavorite79);

            neighborhoodArrayL.add(subFavorite80);
            neighborhoodArrayL.add(subFavorite81);
            neighborhoodArrayL.add(subFavorite82);
            neighborhoodArrayL.add(subFavorite83);
            neighborhoodArrayL.add(subFavorite84);
            neighborhoodArrayL.add(subFavorite85);
            neighborhoodArrayL.add(subFavorite86);
            neighborhoodArrayL.add(subFavorite87);
            neighborhoodArrayL.add(subFavorite88);
            neighborhoodArrayL.add(subFavorite89);

//            neighborhoodArrayL.add(subFavorite130);
        }

        if (city.equals(context.getResources().getString(R.string.sharjah)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.sharjah_abu_shagra),context.getResources().getString(R.string.sharjah_abu_shagra_s),context.getResources().getString(R.string.sharjah_abu_shagra_ar));
            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_badie),context.getResources().getString(R.string.sharjah_al_badie_s),context.getResources().getString(R.string.sharjah_al_badie_ar));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_brashi),context.getResources().getString(R.string.sharjah_al_brashi_s),context.getResources().getString(R.string.sharjah_al_brashi_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_butina),context.getResources().getString(R.string.sharjah_al_butina_s),context.getResources().getString(R.string.sharjah_al_butina_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_ettihad_street),context.getResources().getString(R.string.sharjah_al_ettihad_street_s),context.getResources().getString(R.string.sharjah_al_ettihad_street_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_fayha),context.getResources().getString(R.string.sharjah_al_fayha_s),context.getResources().getString(R.string.sharjah_al_fayha_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_fisht),context.getResources().getString(R.string.sharjah_al_fisht_s),context.getResources().getString(R.string.sharjah_al_fisht_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_garayen),context.getResources().getString(R.string.sharjah_al_garayen_s),context.getResources().getString(R.string.sharjah_al_garayen_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_ghafeyah_area),context.getResources().getString(R.string.sharjah_al_ghafeyah_area_s),context.getResources().getString(R.string.sharjah_al_ghafeyah_area_ar));
            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_gharb),context.getResources().getString(R.string.sharjah_al_gharb_s),context.getResources().getString(R.string.sharjah_al_gharb_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_ghuair),context.getResources().getString(R.string.sharjah_al_ghuair_s),context.getResources().getString(R.string.sharjah_al_ghuair_ar));
            Neighborhood subFavorite12 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_jubail),context.getResources().getString(R.string.sharjah_al_jubail_s),context.getResources().getString(R.string.sharjah_al_jubail_ar));
            Neighborhood subFavorite13 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_jurainah),context.getResources().getString(R.string.sharjah_al_jurainah_s),context.getResources().getString(R.string.sharjah_al_jurainah_ar));
            Neighborhood subFavorite14 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_khezamia),context.getResources().getString(R.string.sharjah_al_khezamia_s),context.getResources().getString(R.string.sharjah_al_khezamia_ar));
            Neighborhood subFavorite15 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_majaz),context.getResources().getString(R.string.sharjah_al_majaz_s),context.getResources().getString(R.string.sharjah_al_majaz_ar));
            Neighborhood subFavorite16 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_mareija),context.getResources().getString(R.string.sharjah_al_mareija_s),context.getResources().getString(R.string.sharjah_al_mareija_ar));
            Neighborhood subFavorite17 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_mujarrah),context.getResources().getString(R.string.sharjah_al_mujarrah_s),context.getResources().getString(R.string.sharjah_al_mujarrah_ar));
            Neighborhood subFavorite18 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_nabba),context.getResources().getString(R.string.sharjah_al_nabba_s),context.getResources().getString(R.string.sharjah_al_nabba_ar));
            Neighborhood subFavorite19 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_nahda),context.getResources().getString(R.string.sharjah_al_nahda_s),context.getResources().getString(R.string.sharjah_al_nahda_ar));
            Neighborhood subFavorite20 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_naimiya_area),context.getResources().getString(R.string.sharjah_al_naimiya_area_s),context.getResources().getString(R.string.sharjah_al_naimiya_area_ar));
            Neighborhood subFavorite21 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_nasreya),context.getResources().getString(R.string.sharjah_al_nasreya_s),context.getResources().getString(R.string.sharjah_al_nasreya_ar));
            Neighborhood subFavorite22 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_nekhailat),context.getResources().getString(R.string.sharjah_al_nekhailat_s),context.getResources().getString(R.string.sharjah_al_nekhailat_ar));
            Neighborhood subFavorite23 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_nouf),context.getResources().getString(R.string.sharjah_al_nouf_s),context.getResources().getString(R.string.sharjah_al_nouf_ar));
            Neighborhood subFavorite24 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_nujoom_islands),context.getResources().getString(R.string.sharjah_al_nujoom_islands_s),context.getResources().getString(R.string.sharjah_al_nujoom_islands_ar));
            Neighborhood subFavorite25 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_qarain),context.getResources().getString(R.string.sharjah_al_qarain_s),context.getResources().getString(R.string.sharjah_al_qarain_ar));
            Neighborhood subFavorite26 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_qasbaa),context.getResources().getString(R.string.sharjah_al_qasbaa_s),context.getResources().getString(R.string.sharjah_al_qasbaa_ar));
            Neighborhood subFavorite27 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_qasemiya),context.getResources().getString(R.string.sharjah_al_qasemiya_s),context.getResources().getString(R.string.sharjah_al_qasemiya_ar));
            Neighborhood subFavorite28 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_rahmaniya),context.getResources().getString(R.string.sharjah_al_rahmaniya_s),context.getResources().getString(R.string.sharjah_al_rahmaniya_ar));
            Neighborhood subFavorite29 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_ramla),context.getResources().getString(R.string.sharjah_al_ramla_s),context.getResources().getString(R.string.sharjah_al_ramla_ar));
            Neighborhood subFavorite30 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_ramtha),context.getResources().getString(R.string.sharjah_al_ramtha_s),context.getResources().getString(R.string.sharjah_al_ramtha_ar));
            Neighborhood subFavorite31 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_riffa_area),context.getResources().getString(R.string.sharjah_al_riffa_area_s),context.getResources().getString(R.string.sharjah_al_riffa_area_ar));
            Neighborhood subFavorite32 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_riqqa),context.getResources().getString(R.string.sharjah_al_riqqa_s),context.getResources().getString(R.string.sharjah_al_riqqa_ar));
            Neighborhood subFavorite33 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_sajaa),context.getResources().getString(R.string.sharjah_al_sajaa_s),context.getResources().getString(R.string.sharjah_al_sajaa_ar));
            Neighborhood subFavorite34 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_shahba),context.getResources().getString(R.string.sharjah_al_shahba_s),context.getResources().getString(R.string.sharjah_al_shahba_ar));
            Neighborhood subFavorite35 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_taawun),context.getResources().getString(R.string.sharjah_al_taawun_s),context.getResources().getString(R.string.sharjah_al_taawun_ar));
            Neighborhood subFavorite36 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_sharq),context.getResources().getString(R.string.sharjah_al_sharq_s),context.getResources().getString(R.string.sharjah_al_sharq_ar));
            Neighborhood subFavorite37 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_suyoh),context.getResources().getString(R.string.sharjah_al_suyoh_s),context.getResources().getString(R.string.sharjah_al_suyoh_ar));
            Neighborhood subFavorite38 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_suyoh_suburb),context.getResources().getString(R.string.sharjah_al_suyoh_suburb_s),context.getResources().getString(R.string.sharjah_al_suyoh_suburb_ar));
            Neighborhood subFavorite39 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_tai),context.getResources().getString(R.string.sharjah_al_tai_s),context.getResources().getString(R.string.sharjah_al_tai_ar));
            Neighborhood subFavorite40 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_tayy_suburb),context.getResources().getString(R.string.sharjah_al_tayy_suburb_s),context.getResources().getString(R.string.sharjah_al_tayy_suburb_ar));
            Neighborhood subFavorite41 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_wahda),context.getResources().getString(R.string.sharjah_al_wahda_s),context.getResources().getString(R.string.sharjah_al_wahda_ar));
            Neighborhood subFavorite42 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_yarmouk),context.getResources().getString(R.string.sharjah_al_yarmouk_s),context.getResources().getString(R.string.sharjah_al_yarmouk_ar));
            Neighborhood subFavorite43 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_zubair),context.getResources().getString(R.string.sharjah_al_zubair_s),context.getResources().getString(R.string.sharjah_al_zubair_ar));
            Neighborhood subFavorite44 = new Neighborhood(context.getResources().getString(R.string.sharjah_cornich_buhaira),context.getResources().getString(R.string.sharjah_cornich_buhaira_s),context.getResources().getString(R.string.sharjah_cornich_buhaira_ar));
            Neighborhood subFavorite45 = new Neighborhood(context.getResources().getString(R.string.sharjah_halwan),context.getResources().getString(R.string.sharjah_halwan_s),context.getResources().getString(R.string.sharjah_halwan_ar));
            Neighborhood subFavorite46 = new Neighborhood(context.getResources().getString(R.string.sharjah_hamriyah_free_zone),context.getResources().getString(R.string.sharjah_hamriyah_free_zone_s),context.getResources().getString(R.string.sharjah_hamriyah_free_zone_ar));
            Neighborhood subFavorite47 = new Neighborhood(context.getResources().getString(R.string.sharjah_jwezaa),context.getResources().getString(R.string.sharjah_jwezaa_s),context.getResources().getString(R.string.sharjah_jwezaa_ar));
            Neighborhood subFavorite48 = new Neighborhood(context.getResources().getString(R.string.sharjah_maysaloon),context.getResources().getString(R.string.sharjah_maysaloon_s),context.getResources().getString(R.string.sharjah_maysaloon_ar));
            Neighborhood subFavorite49 = new Neighborhood(context.getResources().getString(R.string.sharjah_muelih),context.getResources().getString(R.string.sharjah_muelih_s),context.getResources().getString(R.string.sharjah_muelih_ar));
            Neighborhood subFavorite50 = new Neighborhood(context.getResources().getString(R.string.sharjah_muelih_commercial),context.getResources().getString(R.string.sharjah_muelih_commercial_s),context.getResources().getString(R.string.sharjah_muelih_commercial_ar));
            Neighborhood subFavorite51 = new Neighborhood(context.getResources().getString(R.string.sharjah_mughaidir),context.getResources().getString(R.string.sharjah_mughaidir_s),context.getResources().getString(R.string.sharjah_mughaidir_ar));
            Neighborhood subFavorite52 = new Neighborhood(context.getResources().getString(R.string.sharjah_rolla_area),context.getResources().getString(R.string.sharjah_rolla_area_s),context.getResources().getString(R.string.sharjah_rolla_area_ar));
            Neighborhood subFavorite53 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_sharjah_airport_freezon),context.getResources().getString(R.string.sharjah_al_sharjah_airport_freezon_s),context.getResources().getString(R.string.sharjah_al_sharjah_airport_freezon_ar));
            Neighborhood subFavorite54 = new Neighborhood(context.getResources().getString(R.string.sharjah_sharjah_industrial_area),context.getResources().getString(R.string.sharjah_sharjah_industrial_area_s),context.getResources().getString(R.string.sharjah_sharjah_industrial_area_ar));
            Neighborhood subFavorite55 = new Neighborhood(context.getResources().getString(R.string.sharjah_sharqan),context.getResources().getString(R.string.sharjah_sharqan_s),context.getResources().getString(R.string.sharjah_sharqan_ar));
            Neighborhood subFavorite56 = new Neighborhood(context.getResources().getString(R.string.sharjah_tilal_city),context.getResources().getString(R.string.sharjah_tilal_city_s),context.getResources().getString(R.string.sharjah_tilal_city_ar));
            Neighborhood subFavorite57 = new Neighborhood(context.getResources().getString(R.string.sharjah_um_altaraffa),context.getResources().getString(R.string.sharjah_um_altaraffa_s),context.getResources().getString(R.string.sharjah_um_altaraffa_ar));
            Neighborhood subFavorite58 = new Neighborhood(context.getResources().getString(R.string.sharjah_umm_khanoor),context.getResources().getString(R.string.sharjah_umm_khanoor_s),context.getResources().getString(R.string.sharjah_umm_khanoor_ar));
            Neighborhood subFavorite59 = new Neighborhood(context.getResources().getString(R.string.sharjah_wasit),context.getResources().getString(R.string.sharjah_wasit_s),context.getResources().getString(R.string.sharjah_wasit_ar));
            Neighborhood subFavorite60 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_jada),context.getResources().getString(R.string.sharjah_al_jada_s),context.getResources().getString(R.string.sharjah_al_jada_ar));
            Neighborhood subFavorite61 = new Neighborhood(context.getResources().getString(R.string.sharjah_waterfront_city_marina),context.getResources().getString(R.string.sharjah_waterfront_city_marina_s),context.getResources().getString(R.string.sharjah_waterfront_city_marina_ar));
            Neighborhood subFavorite62 = new Neighborhood(context.getResources().getString(R.string.sharjah_hoshi),context.getResources().getString(R.string.sharjah_hoshi_s),context.getResources().getString(R.string.sharjah_hoshi_ar));
            Neighborhood subFavorite63 = new Neighborhood(context.getResources().getString(R.string.sharjah_university_city),context.getResources().getString(R.string.sharjah_university_city_s),context.getResources().getString(R.string.sharjah_university_city_ar));
            Neighborhood subFavorite64 = new Neighborhood(context.getResources().getString(R.string.sharjah_bu_tina),context.getResources().getString(R.string.sharjah_bu_tina_s),context.getResources().getString(R.string.sharjah_bu_tina_ar));
            Neighborhood subFavorite65 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_azra),context.getResources().getString(R.string.sharjah_al_azra_s),context.getResources().getString(R.string.sharjah_al_azra_ar));
            Neighborhood subFavorite66 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_ramaqiya),context.getResources().getString(R.string.sharjah_al_ramaqiya_s),context.getResources().getString(R.string.sharjah_al_ramaqiya_ar));
            Neighborhood subFavorite67 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_falaj),context.getResources().getString(R.string.sharjah_al_falaj_s),context.getResources().getString(R.string.sharjah_al_falaj_ar));
            Neighborhood subFavorite68 = new Neighborhood(context.getResources().getString(R.string.sharjah_al_yash),context.getResources().getString(R.string.sharjah_al_yash_s),context.getResources().getString(R.string.sharjah_al_yash_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);
            neighborhoodArrayL.add(subFavorite12);
            neighborhoodArrayL.add(subFavorite13);
            neighborhoodArrayL.add(subFavorite14);
            neighborhoodArrayL.add(subFavorite15);
            neighborhoodArrayL.add(subFavorite16);
            neighborhoodArrayL.add(subFavorite17);
            neighborhoodArrayL.add(subFavorite18);
            neighborhoodArrayL.add(subFavorite19);

            neighborhoodArrayL.add(subFavorite20);
            neighborhoodArrayL.add(subFavorite21);
            neighborhoodArrayL.add(subFavorite22);
            neighborhoodArrayL.add(subFavorite23);
            neighborhoodArrayL.add(subFavorite24);
            neighborhoodArrayL.add(subFavorite25);
            neighborhoodArrayL.add(subFavorite26);
            neighborhoodArrayL.add(subFavorite27);
            neighborhoodArrayL.add(subFavorite28);
            neighborhoodArrayL.add(subFavorite29);

            neighborhoodArrayL.add(subFavorite30);
            neighborhoodArrayL.add(subFavorite31);
            neighborhoodArrayL.add(subFavorite32);
            neighborhoodArrayL.add(subFavorite33);
            neighborhoodArrayL.add(subFavorite34);
            neighborhoodArrayL.add(subFavorite35);
            neighborhoodArrayL.add(subFavorite36);
            neighborhoodArrayL.add(subFavorite37);
            neighborhoodArrayL.add(subFavorite38);
            neighborhoodArrayL.add(subFavorite39);

            neighborhoodArrayL.add(subFavorite40);
            neighborhoodArrayL.add(subFavorite41);
            neighborhoodArrayL.add(subFavorite42);
            neighborhoodArrayL.add(subFavorite43);
            neighborhoodArrayL.add(subFavorite44);
            neighborhoodArrayL.add(subFavorite45);
            neighborhoodArrayL.add(subFavorite46);
            neighborhoodArrayL.add(subFavorite47);
            neighborhoodArrayL.add(subFavorite48);
            neighborhoodArrayL.add(subFavorite49);

            neighborhoodArrayL.add(subFavorite50);
            neighborhoodArrayL.add(subFavorite51);
            neighborhoodArrayL.add(subFavorite52);
            neighborhoodArrayL.add(subFavorite53);
            neighborhoodArrayL.add(subFavorite54);
            neighborhoodArrayL.add(subFavorite55);
            neighborhoodArrayL.add(subFavorite56);
            neighborhoodArrayL.add(subFavorite57);
            neighborhoodArrayL.add(subFavorite58);
            neighborhoodArrayL.add(subFavorite59);

            neighborhoodArrayL.add(subFavorite60);
            neighborhoodArrayL.add(subFavorite61);
            neighborhoodArrayL.add(subFavorite62);
            neighborhoodArrayL.add(subFavorite63);
            neighborhoodArrayL.add(subFavorite64);
            neighborhoodArrayL.add(subFavorite65);
            neighborhoodArrayL.add(subFavorite66);
            neighborhoodArrayL.add(subFavorite67);
            neighborhoodArrayL.add(subFavorite68);

//            neighborhoodArrayL.add(subFavorite130);
        }

        if (city.equals(context.getResources().getString(R.string.al_ain)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_ain_industrial_area),context.getResources().getString(R.string.al_ain_al_ain_industrial_area_s),context.getResources().getString(R.string.al_ain_al_ain_industrial_area_ar));
//            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_buraymi),context.getResources().getString(R.string.al_ain_al_buraymi_s));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_faqaa),context.getResources().getString(R.string.al_ain_al_faqaa_s),context.getResources().getString(R.string.al_ain_al_faqaa_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_grayyeh),context.getResources().getString(R.string.al_ain_al_grayyeh_s),context.getResources().getString(R.string.al_ain_al_grayyeh_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_hili),context.getResources().getString(R.string.al_ain_al_hili_s),context.getResources().getString(R.string.al_ain_al_hili_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_jaheli),context.getResources().getString(R.string.al_ain_al_jaheli_s),context.getResources().getString(R.string.al_ain_al_jaheli_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_jimi),context.getResources().getString(R.string.al_ain_al_jimi_s),context.getResources().getString(R.string.al_ain_al_jimi_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_khabisi),context.getResources().getString(R.string.al_ain_al_khabisi_s),context.getResources().getString(R.string.al_ain_al_khabisi_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_manaseer),context.getResources().getString(R.string.al_ain_al_manaseer_s),context.getResources().getString(R.string.al_ain_al_manaseer_ar));
            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_maqam),context.getResources().getString(R.string.al_ain_al_maqam_s),context.getResources().getString(R.string.al_ain_al_maqam_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_markhaniya),context.getResources().getString(R.string.al_ain_al_markhaniya_s),context.getResources().getString(R.string.al_ain_al_markhaniya_ar));
            Neighborhood subFavorite12 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_murabaa),context.getResources().getString(R.string.al_ain_al_murabaa_s),context.getResources().getString(R.string.al_ain_al_murabaa_ar));
            Neighborhood subFavorite13 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_mutarad),context.getResources().getString(R.string.al_ain_al_mutarad_s),context.getResources().getString(R.string.al_ain_al_mutarad_ar));
            Neighborhood subFavorite14 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_mutawaa),context.getResources().getString(R.string.al_ain_al_mutawaa_s),context.getResources().getString(R.string.al_ain_al_mutawaa_ar));
            Neighborhood subFavorite15 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_muwahie),context.getResources().getString(R.string.al_ain_al_muwahie_s),context.getResources().getString(R.string.al_ain_al_muwahie_ar));
            Neighborhood subFavorite16 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_muwaiji),context.getResources().getString(R.string.al_ain_al_muwaiji_s),context.getResources().getString(R.string.al_ain_al_muwaiji_ar));
            Neighborhood subFavorite17 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_neyadat),context.getResources().getString(R.string.al_ain_al_neyadat_s),context.getResources().getString(R.string.al_ain_al_neyadat_ar));
            Neighborhood subFavorite18 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_oyoun_village),context.getResources().getString(R.string.al_ain_al_oyoun_village_s),context.getResources().getString(R.string.al_ain_al_oyoun_village_ar));
            Neighborhood subFavorite19 = new Neighborhood(context.getResources().getString(R.string.al_ain_al_sinaiya),context.getResources().getString(R.string.al_ain_al_sinaiya_s),context.getResources().getString(R.string.al_ain_al_sinaiya_ar));
            Neighborhood subFavorite20 = new Neighborhood(context.getResources().getString(R.string.al_ain_tawam),context.getResources().getString(R.string.al_ain_tawam_s),context.getResources().getString(R.string.al_ain_tawam_ar));
            Neighborhood subFavorite21 = new Neighborhood(context.getResources().getString(R.string.al_ain_wahat_al_zaweya),context.getResources().getString(R.string.al_ain_wahat_al_zaweya_s),context.getResources().getString(R.string.al_ain_wahat_al_zaweya_ar));
            Neighborhood subFavorite22 = new Neighborhood(context.getResources().getString(R.string.al_ain_zakher),context.getResources().getString(R.string.al_ain_zakher_s),context.getResources().getString(R.string.al_ain_zakher_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
//            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);
            neighborhoodArrayL.add(subFavorite12);
            neighborhoodArrayL.add(subFavorite13);
            neighborhoodArrayL.add(subFavorite14);
            neighborhoodArrayL.add(subFavorite15);
            neighborhoodArrayL.add(subFavorite16);
            neighborhoodArrayL.add(subFavorite17);
            neighborhoodArrayL.add(subFavorite18);
            neighborhoodArrayL.add(subFavorite19);

            neighborhoodArrayL.add(subFavorite20);
            neighborhoodArrayL.add(subFavorite21);
            neighborhoodArrayL.add(subFavorite22);

//            neighborhoodArrayL.add(subFavorite130);
        }

        if (city.equals(context.getResources().getString(R.string.ajman)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.ajman_ain_ajman),context.getResources().getString(R.string.ajman_ain_ajman_s),context.getResources().getString(R.string.ajman_ain_ajman_ar));
            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.ajman_ajman_corniche_road),context.getResources().getString(R.string.ajman_ajman_corniche_road_s),context.getResources().getString(R.string.ajman_ajman_corniche_road_ar));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.ajman_ajman_downtown),context.getResources().getString(R.string.ajman_ajman_downtown_s),context.getResources().getString(R.string.ajman_ajman_downtown_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.ajman_ajman_industrial_area),context.getResources().getString(R.string.ajman_ajman_industrial_area_s),context.getResources().getString(R.string.ajman_ajman_industrial_area_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.ajman_ajman_meadows),context.getResources().getString(R.string.ajman_ajman_meadows_s),context.getResources().getString(R.string.ajman_ajman_meadows_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.ajman_ajman_uptown),context.getResources().getString(R.string.ajman_ajman_uptown_s),context.getResources().getString(R.string.ajman_ajman_uptown_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.ajman_al_amerah_village),context.getResources().getString(R.string.ajman_al_amerah_village_s),context.getResources().getString(R.string.ajman_al_amerah_village_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.ajman_al_bustan),context.getResources().getString(R.string.ajman_al_bustan_s),context.getResources().getString(R.string.ajman_al_bustan_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.ajman_al_hamidiya),context.getResources().getString(R.string.ajman_al_hamidiya_s),context.getResources().getString(R.string.ajman_al_hamidiya_ar));
            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.ajman_al_humaid_city),context.getResources().getString(R.string.ajman_al_humaid_city_s),context.getResources().getString(R.string.ajman_al_humaid_city_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.ajman_al_ittihad_village),context.getResources().getString(R.string.ajman_al_ittihad_village_s),context.getResources().getString(R.string.ajman_al_ittihad_village_ar));
            Neighborhood subFavorite12 = new Neighborhood(context.getResources().getString(R.string.ajman_al_mwaihat),context.getResources().getString(R.string.ajman_al_mwaihat_s),context.getResources().getString(R.string.ajman_al_mwaihat_ar));
            Neighborhood subFavorite13 = new Neighborhood(context.getResources().getString(R.string.ajman_al_naemiyah),context.getResources().getString(R.string.ajman_al_naemiyah_s),context.getResources().getString(R.string.ajman_al_naemiyah_ar));
            Neighborhood subFavorite14 = new Neighborhood(context.getResources().getString(R.string.ajman_al_raqaib),context.getResources().getString(R.string.ajman_al_raqaib_s),context.getResources().getString(R.string.ajman_al_raqaib_ar));
            Neighborhood subFavorite15 = new Neighborhood(context.getResources().getString(R.string.ajman_al_rashidiya),context.getResources().getString(R.string.ajman_al_rashidiya_s),context.getResources().getString(R.string.ajman_al_rashidiya_ar));
            Neighborhood subFavorite16 = new Neighborhood(context.getResources().getString(R.string.ajman_al_rawda),context.getResources().getString(R.string.ajman_al_rawda_s),context.getResources().getString(R.string.ajman_al_rawda_ar));
            Neighborhood subFavorite17 = new Neighborhood(context.getResources().getString(R.string.ajman_al_rumaila),context.getResources().getString(R.string.ajman_al_rumaila_s),context.getResources().getString(R.string.ajman_al_rumaila_ar));
            Neighborhood subFavorite18 = new Neighborhood(context.getResources().getString(R.string.ajman_al_sawan),context.getResources().getString(R.string.ajman_al_sawan_s),context.getResources().getString(R.string.ajman_al_sawan_ar));
            Neighborhood subFavorite19 = new Neighborhood(context.getResources().getString(R.string.ajman_al_zahraa),context.getResources().getString(R.string.ajman_al_zahraa_s),context.getResources().getString(R.string.ajman_al_zahraa_ar));
            Neighborhood subFavorite20 = new Neighborhood(context.getResources().getString(R.string.ajman_al_zorah),context.getResources().getString(R.string.ajman_al_zorah_s),context.getResources().getString(R.string.ajman_al_zorah_ar));
            Neighborhood subFavorite21 = new Neighborhood(context.getResources().getString(R.string.ajman_awali_city),context.getResources().getString(R.string.ajman_awali_city_s),context.getResources().getString(R.string.ajman_awali_city_ar));
            Neighborhood subFavorite22 = new Neighborhood(context.getResources().getString(R.string.ajman_garden_city),context.getResources().getString(R.string.ajman_garden_city_s),context.getResources().getString(R.string.ajman_garden_city_ar));
            Neighborhood subFavorite23 = new Neighborhood(context.getResources().getString(R.string.ajman_green_city),context.getResources().getString(R.string.ajman_green_city_s),context.getResources().getString(R.string.ajman_green_city_ar));
            Neighborhood subFavorite24 = new Neighborhood(context.getResources().getString(R.string.ajman_manama),context.getResources().getString(R.string.ajman_manama_s),context.getResources().getString(R.string.ajman_manama_ar));
            Neighborhood subFavorite25 = new Neighborhood(context.getResources().getString(R.string.ajman_marmooka_city),context.getResources().getString(R.string.ajman_marmooka_city_s),context.getResources().getString(R.string.ajman_marmooka_city_ar));
            Neighborhood subFavorite26 = new Neighborhood(context.getResources().getString(R.string.ajman_masfoot),context.getResources().getString(R.string.ajman_masfoot_s),context.getResources().getString(R.string.ajman_masfoot_ar));
            Neighborhood subFavorite27 = new Neighborhood(context.getResources().getString(R.string.ajman_musheiref),context.getResources().getString(R.string.ajman_musheiref_s),context.getResources().getString(R.string.ajman_musheiref_ar));
            Neighborhood subFavorite28 = new Neighborhood(context.getResources().getString(R.string.ajman_new_industrial_area),context.getResources().getString(R.string.ajman_new_industrial_area_s),context.getResources().getString(R.string.ajman_new_industrial_area_ar));
            Neighborhood subFavorite29 = new Neighborhood(context.getResources().getString(R.string.ajman_park_view_city),context.getResources().getString(R.string.ajman_park_view_city_s),context.getResources().getString(R.string.ajman_park_view_city_ar));
            Neighborhood subFavorite30 = new Neighborhood(context.getResources().getString(R.string.ajman_sheikh_khalifa_bin_zayed_street),context.getResources().getString(R.string.ajman_sheikh_khalifa_bin_zayed_street_s),context.getResources().getString(R.string.ajman_sheikh_khalifa_bin_zayed_street_ar));
            Neighborhood subFavorite31 = new Neighborhood(context.getResources().getString(R.string.ajman_al_helio),context.getResources().getString(R.string.ajman_al_helio_s),context.getResources().getString(R.string.ajman_al_helio_ar));
            Neighborhood subFavorite32 = new Neighborhood(context.getResources().getString(R.string.ajman_al_jurf),context.getResources().getString(R.string.ajman_al_jurf_s),context.getResources().getString(R.string.ajman_al_jurf_ar));
            Neighborhood subFavorite33 = new Neighborhood(context.getResources().getString(R.string.ajman_sheikh_maktoum_bin_rashid_rd),context.getResources().getString(R.string.ajman_sheikh_maktoum_bin_rashid_rd_s),context.getResources().getString(R.string.ajman_sheikh_maktoum_bin_rashid_rd_ar));
            Neighborhood subFavorite34 = new Neighborhood(context.getResources().getString(R.string.ajman_al_amerah),context.getResources().getString(R.string.ajman_al_amerah_s),context.getResources().getString(R.string.ajman_al_amerah_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);
            neighborhoodArrayL.add(subFavorite12);
            neighborhoodArrayL.add(subFavorite13);
            neighborhoodArrayL.add(subFavorite14);
            neighborhoodArrayL.add(subFavorite15);
            neighborhoodArrayL.add(subFavorite16);
            neighborhoodArrayL.add(subFavorite17);
            neighborhoodArrayL.add(subFavorite18);
            neighborhoodArrayL.add(subFavorite19);

            neighborhoodArrayL.add(subFavorite20);
            neighborhoodArrayL.add(subFavorite21);
            neighborhoodArrayL.add(subFavorite23);
            neighborhoodArrayL.add(subFavorite24);
            neighborhoodArrayL.add(subFavorite25);
            neighborhoodArrayL.add(subFavorite26);
            neighborhoodArrayL.add(subFavorite27);
            neighborhoodArrayL.add(subFavorite28);
            neighborhoodArrayL.add(subFavorite29);
            neighborhoodArrayL.add(subFavorite30);

            neighborhoodArrayL.add(subFavorite31);
            neighborhoodArrayL.add(subFavorite32);
            neighborhoodArrayL.add(subFavorite33);
            neighborhoodArrayL.add(subFavorite34);

//            neighborhoodArrayL.add(subFavorite130);
        }

        if (city.equals(context.getResources().getString(R.string.ras_al_khaimah)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_dhait),context.getResources().getString(R.string.ras_al_khaimah_al_dhait_s),context.getResources().getString(R.string.ras_al_khaimah_al_dhait_ar));
            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_ghubb),context.getResources().getString(R.string.ras_al_khaimah_al_ghubb_s),context.getResources().getString(R.string.ras_al_khaimah_al_ghubb_ar));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_huamra),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_s),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_huamra_village),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_village_s),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_village_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_juwais),context.getResources().getString(R.string.ras_al_khaimah_al_juwais_s),context.getResources().getString(R.string.ras_al_khaimah_al_juwais_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_mamourah),context.getResources().getString(R.string.ras_al_khaimah_al_mamourah_s),context.getResources().getString(R.string.ras_al_khaimah_al_mamourah_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_marjan_island),context.getResources().getString(R.string.ras_al_khaimah_al_marjan_island_s),context.getResources().getString(R.string.ras_al_khaimah_al_marjan_island_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_nakheel),context.getResources().getString(R.string.ras_al_khaimah_al_nakheel_s),context.getResources().getString(R.string.ras_al_khaimah_al_nakheel_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_qusaidat),context.getResources().getString(R.string.ras_al_khaimah_al_qusaidat_s),context.getResources().getString(R.string.ras_al_khaimah_al_qusaidat_ar));
            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_al_uraibi),context.getResources().getString(R.string.ras_al_khaimah_al_uraibi_s),context.getResources().getString(R.string.ras_al_khaimah_al_uraibi_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_cornich_ras_al_khaima),context.getResources().getString(R.string.ras_al_khaimah_cornich_ras_al_khaima_s),context.getResources().getString(R.string.ras_al_khaimah_cornich_ras_al_khaima_ar));
            Neighborhood subFavorite12 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_dana_island),context.getResources().getString(R.string.ras_al_khaimah_dana_island_s),context.getResources().getString(R.string.ras_al_khaimah_dana_island_ar));
            Neighborhood subFavorite13 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_julfar),context.getResources().getString(R.string.ras_al_khaimah_julfar_s),context.getResources().getString(R.string.ras_al_khaimah_julfar_ar));
            Neighborhood subFavorite14 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_khuzam),context.getResources().getString(R.string.ras_al_khaimah_khuzam_s),context.getResources().getString(R.string.ras_al_khaimah_khuzam_ar));
            Neighborhood subFavorite15 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_mina_al_arab),context.getResources().getString(R.string.ras_al_khaimah_mina_al_arab_s),context.getResources().getString(R.string.ras_al_khaimah_mina_al_arab_ar));
            Neighborhood subFavorite16 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_pak_ftz),context.getResources().getString(R.string.ras_al_khaimah_pak_ftz_s),context.getResources().getString(R.string.ras_al_khaimah_pak_ftz_ar));
            Neighborhood subFavorite17 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_pak_industrial_and_technology_park),context.getResources().getString(R.string.ras_al_khaimah_pak_industrial_and_technology_park_s),context.getResources().getString(R.string.ras_al_khaimah_pak_industrial_and_technology_park_ar));
            Neighborhood subFavorite18 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_creek),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_creek_s),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_creek_ar));
            Neighborhood subFavorite19 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_gateway),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_gateway_s),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_gateway_ar));
            Neighborhood subFavorite20 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_waterfront),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_waterfront_s),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_waterfront_ar));
            Neighborhood subFavorite21 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_saraya_islands),context.getResources().getString(R.string.ras_al_khaimah_saraya_islands_s),context.getResources().getString(R.string.ras_al_khaimah_saraya_islands_ar));
            Neighborhood subFavorite22 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_sheikh_mohammad_bin_zayed_road),context.getResources().getString(R.string.ras_al_khaimah_sheikh_mohammad_bin_zayed_road_s),context.getResources().getString(R.string.ras_al_khaimah_sheikh_mohammad_bin_zayed_road_ar));
            Neighborhood subFavorite23 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_sidroh),context.getResources().getString(R.string.ras_al_khaimah_sidroh_s),context.getResources().getString(R.string.ras_al_khaimah_sidroh_ar));
            Neighborhood subFavorite24 = new Neighborhood(context.getResources().getString(R.string.ras_al_khaimah_yasmin_village),context.getResources().getString(R.string.ras_al_khaimah_yasmin_village_s),context.getResources().getString(R.string.ras_al_khaimah_yasmin_village_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);
            neighborhoodArrayL.add(subFavorite12);
            neighborhoodArrayL.add(subFavorite13);
            neighborhoodArrayL.add(subFavorite14);
            neighborhoodArrayL.add(subFavorite15);
            neighborhoodArrayL.add(subFavorite16);
            neighborhoodArrayL.add(subFavorite17);
            neighborhoodArrayL.add(subFavorite18);
            neighborhoodArrayL.add(subFavorite19);

            neighborhoodArrayL.add(subFavorite20);
            neighborhoodArrayL.add(subFavorite21);
            neighborhoodArrayL.add(subFavorite22);
            neighborhoodArrayL.add(subFavorite23);
            neighborhoodArrayL.add(subFavorite24);

//            neighborhoodArrayL.add(subFavorite130);
        }

        if (city.equals(context.getResources().getString(R.string.um_al_quwain)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_aahad),context.getResources().getString(R.string.um_al_quwain_al_aahad_s),context.getResources().getString(R.string.um_al_quwain_al_aahad_ar));
            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_dar_al_baidaa),context.getResources().getString(R.string.um_al_quwain_al_dar_al_baidaa_s),context.getResources().getString(R.string.um_al_quwain_al_dar_al_baidaa_ar));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_haditha),context.getResources().getString(R.string.um_al_quwain_al_haditha_s),context.getResources().getString(R.string.um_al_quwain_al_haditha_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_humra),context.getResources().getString(R.string.um_al_quwain_al_humra_s),context.getResources().getString(R.string.um_al_quwain_al_humra_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_kaber),context.getResources().getString(R.string.um_al_quwain_al_kaber_s),context.getResources().getString(R.string.um_al_quwain_al_kaber_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_khor),context.getResources().getString(R.string.um_al_quwain_al_khor_s),context.getResources().getString(R.string.um_al_quwain_al_khor_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_maidan),context.getResources().getString(R.string.um_al_quwain_al_maidan_s),context.getResources().getString(R.string.um_al_quwain_al_maidan_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_raas),context.getResources().getString(R.string.um_al_quwain_al_raas_s),context.getResources().getString(R.string.um_al_quwain_al_raas_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_ramla),context.getResources().getString(R.string.um_al_quwain_al_ramla_s),context.getResources().getString(R.string.um_al_quwain_al_ramla_ar));
            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_raudah),context.getResources().getString(R.string.um_al_quwain_al_raudah_s),context.getResources().getString(R.string.um_al_quwain_al_raudah_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_riqqa),context.getResources().getString(R.string.um_al_quwain_al_riqqa_s),context.getResources().getString(R.string.um_al_quwain_al_riqqa_ar));
            Neighborhood subFavorite12 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_salam_city),context.getResources().getString(R.string.um_al_quwain_al_salam_city_s),context.getResources().getString(R.string.um_al_quwain_al_salam_city_ar));
            Neighborhood subFavorite13 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_salamah),context.getResources().getString(R.string.um_al_quwain_al_salamah_s),context.getResources().getString(R.string.um_al_quwain_al_salamah_ar));
            Neighborhood subFavorite14 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_al_surra),context.getResources().getString(R.string.um_al_quwain_al_surra_s),context.getResources().getString(R.string.um_al_quwain_al_surra_ar));
            Neighborhood subFavorite15 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_emirates_modern_industrial),context.getResources().getString(R.string.um_al_quwain_emirates_modern_industrial_s),context.getResources().getString(R.string.um_al_quwain_emirates_modern_industrial_ar));
            Neighborhood subFavorite16 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_falaj_al_moalla),context.getResources().getString(R.string.um_al_quwain_falaj_al_moalla_s),context.getResources().getString(R.string.um_al_quwain_falaj_al_moalla_ar));
            Neighborhood subFavorite17 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_khor_al_beidah),context.getResources().getString(R.string.um_al_quwain_khor_al_beidah_s),context.getResources().getString(R.string.um_al_quwain_khor_al_beidah_ar));
            Neighborhood subFavorite18 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_old_induustrial_area),context.getResources().getString(R.string.um_al_quwain_old_induustrial_area_s),context.getResources().getString(R.string.um_al_quwain_old_induustrial_area_ar));
            Neighborhood subFavorite19 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_umm_al_quwain_marina),context.getResources().getString(R.string.um_al_quwain_umm_al_quwain_marina_s),context.getResources().getString(R.string.um_al_quwain_umm_al_quwain_marina_ar));
            Neighborhood subFavorite20 = new Neighborhood(context.getResources().getString(R.string.um_al_quwain_white_bay),context.getResources().getString(R.string.um_al_quwain_white_bay_s),context.getResources().getString(R.string.um_al_quwain_white_bay_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);
            neighborhoodArrayL.add(subFavorite12);
            neighborhoodArrayL.add(subFavorite13);
            neighborhoodArrayL.add(subFavorite14);
            neighborhoodArrayL.add(subFavorite15);
            neighborhoodArrayL.add(subFavorite16);
            neighborhoodArrayL.add(subFavorite17);
            neighborhoodArrayL.add(subFavorite18);
            neighborhoodArrayL.add(subFavorite19);

            neighborhoodArrayL.add(subFavorite20);

//            neighborhoodArrayL.add(subFavorite130);
        }

        if (city.equals(context.getResources().getString(R.string.fujairah)))
        {
            Neighborhood subFavorite1 = new Neighborhood(context.getResources().getString(R.string.fujairah_sharm),context.getResources().getString(R.string.fujairah_sharm_s),context.getResources().getString(R.string.fujairah_sharm_ar));
            Neighborhood subFavorite2 = new Neighborhood(context.getResources().getString(R.string.fujairah_gurfah),context.getResources().getString(R.string.fujairah_gurfah_s),context.getResources().getString(R.string.fujairah_gurfah_ar));
            Neighborhood subFavorite3 = new Neighborhood(context.getResources().getString(R.string.fujairah_faseel),context.getResources().getString(R.string.fujairah_faseel_s),context.getResources().getString(R.string.fujairah_faseel_ar));
            Neighborhood subFavorite4 = new Neighborhood(context.getResources().getString(R.string.fujairah_fujairah_freezone),context.getResources().getString(R.string.fujairah_fujairah_freezone_s),context.getResources().getString(R.string.fujairah_fujairah_freezone_ar));
            Neighborhood subFavorite5 = new Neighborhood(context.getResources().getString(R.string.fujairah_sakamkam),context.getResources().getString(R.string.fujairah_sakamkam_s),context.getResources().getString(R.string.fujairah_sakamkam_ar));
            Neighborhood subFavorite6 = new Neighborhood(context.getResources().getString(R.string.fujairah_saniaya),context.getResources().getString(R.string.fujairah_saniaya_s),context.getResources().getString(R.string.fujairah_saniaya_ar));
            Neighborhood subFavorite7 = new Neighborhood(context.getResources().getString(R.string.fujairah_merashid),context.getResources().getString(R.string.fujairah_merashid_s),context.getResources().getString(R.string.fujairah_merashid_ar));
            Neighborhood subFavorite8 = new Neighborhood(context.getResources().getString(R.string.fujairah_corniche_fujairah),context.getResources().getString(R.string.fujairah_corniche_fujairah_s),context.getResources().getString(R.string.fujairah_corniche_fujairah_ar));
            Neighborhood subFavorite9 = new Neighborhood(context.getResources().getString(R.string.fujairah_deba_fujairah),context.getResources().getString(R.string.fujairah_deba_fujairah_s),context.getResources().getString(R.string.fujairah_deba_fujairah_ar));
            Neighborhood subFavorite10 = new Neighborhood(context.getResources().getString(R.string.fujairah_downtown_fujairah),context.getResources().getString(R.string.fujairah_downtown_fujairah_s),context.getResources().getString(R.string.fujairah_downtown_fujairah_ar));
            Neighborhood subFavorite11 = new Neighborhood(context.getResources().getString(R.string.fujairah_sheikh_hamad_bin_abdullah_st),context.getResources().getString(R.string.fujairah_sheikh_hamad_bin_abdullah_st_s),context.getResources().getString(R.string.fujairah_sheikh_hamad_bin_abdullah_st_ar));

//            Neighborhood subFavorite130 = new Neighborhood(context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find));

            neighborhoodArrayL.add(subFavorite1);
            neighborhoodArrayL.add(subFavorite2);
            neighborhoodArrayL.add(subFavorite3);
            neighborhoodArrayL.add(subFavorite4);
            neighborhoodArrayL.add(subFavorite5);
            neighborhoodArrayL.add(subFavorite6);
            neighborhoodArrayL.add(subFavorite7);
            neighborhoodArrayL.add(subFavorite8);
            neighborhoodArrayL.add(subFavorite9);

            neighborhoodArrayL.add(subFavorite10);
            neighborhoodArrayL.add(subFavorite11);

//            neighborhoodArrayL.add(subFavorite130);
        }

        return neighborhoodArrayL;
    }

    public static ArrayList<CityWithNeighborhood> fillCityAndNeighborhoodArrayL
            (ArrayList<CityWithNeighborhood> cityWithNeighborhoodArrayL, Context context) {
        cityWithNeighborhoodArrayL = new ArrayList<CityWithNeighborhood>();

        CityWithNeighborhood cityWithNeighborhood1 = new CityWithNeighborhood("1","1",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_acacia),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_acacia_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_acacia_ar));
        CityWithNeighborhood cityWithNeighborhood2 = new CityWithNeighborhood("1","2",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_academic),context.getResources().getString(R.string.dubai_s),context.getString(R.string.dubai_academic_s),context.getResources().getString(R.string.dubai_ar),context.getString(R.string.dubai_academic_ar));
        CityWithNeighborhood cityWithNeighborhood3 = new CityWithNeighborhood("1","3",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_alaweer),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_alaweer_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_alaweer_ar));
        CityWithNeighborhood cityWithNeighborhood4 = new CityWithNeighborhood("1","4",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_albadaa),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_albadaa_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_albadaa_ar));
        CityWithNeighborhood cityWithNeighborhood5 = new CityWithNeighborhood("1","5",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_albarari),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_albarari_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_albarari_ar));
        CityWithNeighborhood cityWithNeighborhood6 = new CityWithNeighborhood("1","6",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_albarsha),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_albarsha_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_albarsha_ar));
        CityWithNeighborhood cityWithNeighborhood7 = new CityWithNeighborhood("1","7",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_furjan),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_furjan_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_furjan_ar));
        CityWithNeighborhood cityWithNeighborhood8 = new CityWithNeighborhood("1","8",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_garhoud),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_garhoud_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_garhoud_ar));
        CityWithNeighborhood cityWithNeighborhood9 = new CityWithNeighborhood("1","9",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_hamriya),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_hamriya_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_hamriya_ar));
        CityWithNeighborhood cityWithNeighborhood10 = new CityWithNeighborhood("1","10",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_jaddaf),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_jaddaf_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_jaddaf_ar));
        CityWithNeighborhood cityWithNeighborhood11 = new CityWithNeighborhood("1","11",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_jafiliya),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_jafiliya_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_jafiliya_ar));
        CityWithNeighborhood cityWithNeighborhood12 = new CityWithNeighborhood("1","12",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_khawaneej),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_khawaneej_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_khawaneej_ar));
        CityWithNeighborhood cityWithNeighborhood13 = new CityWithNeighborhood("1","13",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_mizhar),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_mizhar_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_mizhar_ar));
        CityWithNeighborhood cityWithNeighborhood14 = new CityWithNeighborhood("1","14",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_muhaisnah),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_muhaisnah_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_muhaisnah_ar));
        CityWithNeighborhood cityWithNeighborhood15 = new CityWithNeighborhood("1","15",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_nahda),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_nahda_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_nahda_ar));
        CityWithNeighborhood cityWithNeighborhood16 = new CityWithNeighborhood("1","16",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_quoz),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_quoz_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_quoz_ar));
        CityWithNeighborhood cityWithNeighborhood17 = new CityWithNeighborhood("1","17",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_qusais),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_qusais_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_qusais_ar));
        CityWithNeighborhood cityWithNeighborhood18 = new CityWithNeighborhood("1","18",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_rashidiya),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_rashidiya_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_rashidiya_ar));
        CityWithNeighborhood cityWithNeighborhood19 = new CityWithNeighborhood("1","19",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_safa),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_safa_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_safa_ar));
        CityWithNeighborhood cityWithNeighborhood20 = new CityWithNeighborhood("1","20",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_satwa),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_satwa_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_satwa_ar));
        CityWithNeighborhood cityWithNeighborhood21 = new CityWithNeighborhood("1","21",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_shindagah),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_shindagah_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_shindagah_ar));
        CityWithNeighborhood cityWithNeighborhood22 = new CityWithNeighborhood("1","22",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_sufouh),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_sufouh_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_sufouh_ar));
        CityWithNeighborhood cityWithNeighborhood23 = new CityWithNeighborhood("1","23",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_twar),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_twar_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_twar_ar));
        CityWithNeighborhood cityWithNeighborhood24 = new CityWithNeighborhood("1","24",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_warqaa),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_warqaa_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_warqaa_ar));
        CityWithNeighborhood cityWithNeighborhood25 = new CityWithNeighborhood("1","25",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_warsan),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_warsan_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_warsan_ar));
        CityWithNeighborhood cityWithNeighborhood26 = new CityWithNeighborhood("1","26",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_wasl),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_wasl_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_wasl_ar));
        CityWithNeighborhood cityWithNeighborhood27 = new CityWithNeighborhood("1","27",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_arabian_ranches),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_arabian_ranches_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_arabian_ranches_ar));
        CityWithNeighborhood cityWithNeighborhood28 = new CityWithNeighborhood("1","28",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_bur_dubai),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_bur_dubai_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_bur_dubai_ar));
        CityWithNeighborhood cityWithNeighborhood29 = new CityWithNeighborhood("1","29",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_business_bay),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_business_bay_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_business_bay_ar));
        CityWithNeighborhood cityWithNeighborhood30 = new CityWithNeighborhood("1","30",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_culture_village),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_culture_village_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_culture_village_ar));
        CityWithNeighborhood cityWithNeighborhood31 = new CityWithNeighborhood("1","31",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_deira),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_deira_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_deira_ar));
        CityWithNeighborhood cityWithNeighborhood32 = new CityWithNeighborhood("1","32",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_difc),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_difc_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_difc_ar));
        CityWithNeighborhood cityWithNeighborhood33 = new CityWithNeighborhood("1","33",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_discovery_gardens),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_discovery_gardens_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_discovery_gardens_ar));
        CityWithNeighborhood cityWithNeighborhood34 = new CityWithNeighborhood("1","34",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_downtown_dubai),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_downtown_dubai_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_downtown_dubai_ar));
        CityWithNeighborhood cityWithNeighborhood35 = new CityWithNeighborhood("1","35",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_downtown_jebel_ali),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_downtown_jebel_ali_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_downtown_jebel_ali_ar));
        CityWithNeighborhood cityWithNeighborhood36 = new CityWithNeighborhood("1","36",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_design_district),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_design_district_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_design_district_ar));
        CityWithNeighborhood cityWithNeighborhood37 = new CityWithNeighborhood("1","37",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_festival_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_festival_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_festival_city_ar));
        CityWithNeighborhood cityWithNeighborhood38 = new CityWithNeighborhood("1","38",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_healthcare_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_healthcare_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_healthcare_city_ar));
        CityWithNeighborhood cityWithNeighborhood39 = new CityWithNeighborhood("1","39",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_hills_estate),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_hills_estate_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_hills_estate_ar));
        CityWithNeighborhood cityWithNeighborhood40 = new CityWithNeighborhood("1","40",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_industrial_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_industrial_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_industrial_city_ar));
        CityWithNeighborhood cityWithNeighborhood41 = new CityWithNeighborhood("1","41",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_international_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_international_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_international_city_ar));
        CityWithNeighborhood cityWithNeighborhood42 = new CityWithNeighborhood("1","42",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_investment_park),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_investment_park_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_investment_park_ar));
        CityWithNeighborhood cityWithNeighborhood43 = new CityWithNeighborhood("1","43",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_land),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_land_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_land_ar));
        CityWithNeighborhood cityWithNeighborhood44 = new CityWithNeighborhood("1","44",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_marina),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_marina_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_marina_ar));
        CityWithNeighborhood cityWithNeighborhood45 = new CityWithNeighborhood("1","45",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_media_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_media_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_media_city_ar));
        CityWithNeighborhood cityWithNeighborhood46 = new CityWithNeighborhood("1","46",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_pearl),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_pearl_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_pearl_ar));
        CityWithNeighborhood cityWithNeighborhood47 = new CityWithNeighborhood("1","47",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_promenade),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_promenade_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_promenade_ar));
        CityWithNeighborhood cityWithNeighborhood48 = new CityWithNeighborhood("1","48",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_silicon_oasis),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_silicon_oasis_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_silicon_oasis_ar));
        CityWithNeighborhood cityWithNeighborhood49 = new CityWithNeighborhood("1","49",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_sports_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_sports_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_sports_city_ar));
        CityWithNeighborhood cityWithNeighborhood50 = new CityWithNeighborhood("1","50",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_studio_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_studio_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_studio_city_ar));
        CityWithNeighborhood cityWithNeighborhood51 = new CityWithNeighborhood("1","51",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_waterfront),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_waterfront_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_waterfront_ar));
        CityWithNeighborhood cityWithNeighborhood52 = new CityWithNeighborhood("1","52",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_world_central),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_world_central_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_world_central_ar));
        CityWithNeighborhood cityWithNeighborhood53 = new CityWithNeighborhood("1","53",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_du_biotech),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_du_biotech_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_du_biotech_ar));
        CityWithNeighborhood cityWithNeighborhood54 = new CityWithNeighborhood("1","54",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_emirates_golf_club),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_emirates_golf_club_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_emirates_golf_club_ar));
        CityWithNeighborhood cityWithNeighborhood55 = new CityWithNeighborhood("1","55",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_emirates_hills),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_emirates_hills_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_emirates_hills_ar));
        CityWithNeighborhood cityWithNeighborhood56 = new CityWithNeighborhood("1","56",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_global_village),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_global_village_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_global_village_ar));
        CityWithNeighborhood cityWithNeighborhood57 = new CityWithNeighborhood("1","57",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_green_community),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_green_community_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_green_community_ar));
        CityWithNeighborhood cityWithNeighborhood58 = new CityWithNeighborhood("1","58",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_greens),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_greens_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_greens_ar));
        CityWithNeighborhood cityWithNeighborhood59 = new CityWithNeighborhood("1","59",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_hatta),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_hatta_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_hatta_ar));
        CityWithNeighborhood cityWithNeighborhood60 = new CityWithNeighborhood("1","60",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_impz),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_impz_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_impz_ar));
        CityWithNeighborhood cityWithNeighborhood61 = new CityWithNeighborhood("1","61",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jebel_ali),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jebel_ali_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jebel_ali_ar));
        CityWithNeighborhood cityWithNeighborhood62 = new CityWithNeighborhood("1","62",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_ar));
        CityWithNeighborhood cityWithNeighborhood63 = new CityWithNeighborhood("1","63",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_beach_residence),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_beach_residence_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_beach_residence_ar));
        CityWithNeighborhood cityWithNeighborhood64 = new CityWithNeighborhood("1","64",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_golf_estates),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_golf_estates_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_golf_estates_ar));
        CityWithNeighborhood cityWithNeighborhood65 = new CityWithNeighborhood("1","65",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_heights),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_heights_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_heights_ar));
        CityWithNeighborhood cityWithNeighborhood66 = new CityWithNeighborhood("1","66",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_islands),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_islands_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_islands_ar));
        CityWithNeighborhood cityWithNeighborhood67 = new CityWithNeighborhood("1","67",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_lake_towers),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_lake_towers_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_lake_towers_ar));
        CityWithNeighborhood cityWithNeighborhood68 = new CityWithNeighborhood("1","68",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_park),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_park_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_park_ar));
        CityWithNeighborhood cityWithNeighborhood69 = new CityWithNeighborhood("1","69",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_village_circle),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_village_circle_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_village_circle_ar));
        CityWithNeighborhood cityWithNeighborhood70 = new CityWithNeighborhood("1","70",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_jumeirah_village_triangle),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_jumeirah_village_triangle_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_jumeirah_village_triangle_ar));
        CityWithNeighborhood cityWithNeighborhood71 = new CityWithNeighborhood("1","71",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_karama),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_karama_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_karama_ar));
        CityWithNeighborhood cityWithNeighborhood72 = new CityWithNeighborhood("1","72",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_maritime_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_maritime_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_maritime_city_ar));
        CityWithNeighborhood cityWithNeighborhood73 = new CityWithNeighborhood("1","73",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_meadows),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_meadows_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_meadows_ar));
        CityWithNeighborhood cityWithNeighborhood74 = new CityWithNeighborhood("1","74",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_meydan_avenue),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_meydan_avenue_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_meydan_avenue_ar));
        CityWithNeighborhood cityWithNeighborhood75 = new CityWithNeighborhood("1","75",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_meydan_gated_community),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_meydan_gated_community_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_meydan_gated_community_ar));
        CityWithNeighborhood cityWithNeighborhood76 = new CityWithNeighborhood("1","76",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_mina_al_arab),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_mina_al_arab_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_mina_al_arab_ar));
        CityWithNeighborhood cityWithNeighborhood77 = new CityWithNeighborhood("1","77",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_mirdif),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_mirdif_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_mirdif_ar));
        CityWithNeighborhood cityWithNeighborhood78 = new CityWithNeighborhood("1","78",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_mohammad_bin_tashid_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_mohammad_bin_tashid_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_mohammad_bin_tashid_city_ar));
        CityWithNeighborhood cityWithNeighborhood79 = new CityWithNeighborhood("1","79",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_motor_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_motor_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_motor_city_ar));
        CityWithNeighborhood cityWithNeighborhood80 = new CityWithNeighborhood("1","80",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_motor_city),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_motor_city_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_motor_city_ar));
        CityWithNeighborhood cityWithNeighborhood81 = new CityWithNeighborhood("1","81",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_mushrif_park),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_mushrif_park_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_mushrif_park_ar));
        CityWithNeighborhood cityWithNeighborhood82 = new CityWithNeighborhood("1","82",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_nadd_al_hammar),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_nadd_al_hammar_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_nadd_al_hammar_ar));
        CityWithNeighborhood cityWithNeighborhood83 = new CityWithNeighborhood("1","83",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_nadd_al_sheba),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_nadd_al_sheba_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_nadd_al_sheba_ar));
        CityWithNeighborhood cityWithNeighborhood84 = new CityWithNeighborhood("1","84",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_old_town),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_old_town_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_old_town_ar));
        CityWithNeighborhood cityWithNeighborhood85 = new CityWithNeighborhood("1","85",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_oud_al_muteena),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_oud_al_muteena_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_oud_al_muteena_ar));
        CityWithNeighborhood cityWithNeighborhood86 = new CityWithNeighborhood("1","86",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_palm_jebel_ali),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_palm_jebel_ali_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_palm_jebel_ali_ar));
        CityWithNeighborhood cityWithNeighborhood87 = new CityWithNeighborhood("1","87",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_palm_jumeirah),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_palm_jumeirah_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_palm_jumeirah_ar));
        CityWithNeighborhood cityWithNeighborhood88 = new CityWithNeighborhood("1","88",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_ras_al_khor),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_ras_al_khor_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_ras_al_khor_ar));
        CityWithNeighborhood cityWithNeighborhood89 = new CityWithNeighborhood("1","89",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_reem),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_reem_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_reem_ar));
        CityWithNeighborhood cityWithNeighborhood90 = new CityWithNeighborhood("1","90",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_sheikh_zayed_road),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_sheikh_zayed_road_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_sheikh_zayed_road_ar));
        CityWithNeighborhood cityWithNeighborhood91 = new CityWithNeighborhood("1","91",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_technology_park),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_technology_park_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_technology_park_ar));
        CityWithNeighborhood cityWithNeighborhood92 = new CityWithNeighborhood("1","92",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_tecom),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_tecom_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_tecom_ar));
        CityWithNeighborhood cityWithNeighborhood93 = new CityWithNeighborhood("1","93",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_gardens),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_gardens_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_gardens_ar));
        CityWithNeighborhood cityWithNeighborhood94 = new CityWithNeighborhood("1","94",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_hills),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_hills_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_hills_ar));
        CityWithNeighborhood cityWithNeighborhood95 = new CityWithNeighborhood("1","95",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_lagoons),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_lagoons_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_lagoons_ar));
        CityWithNeighborhood cityWithNeighborhood96 = new CityWithNeighborhood("1","96",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_lakes),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_lakes_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_lakes_ar));
        CityWithNeighborhood cityWithNeighborhood97 = new CityWithNeighborhood("1","97",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_meadows),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_meadows_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_meadows_ar));
        CityWithNeighborhood cityWithNeighborhood98 = new CityWithNeighborhood("1","98",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_palm_deira),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_palm_deira_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_palm_deira_ar));
        CityWithNeighborhood cityWithNeighborhood99 = new CityWithNeighborhood("1","99",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_springs),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_springs_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_springs_ar));
        CityWithNeighborhood cityWithNeighborhood100 = new CityWithNeighborhood("1","100",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_views),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_views_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_views_ar));
        CityWithNeighborhood cityWithNeighborhood101 = new CityWithNeighborhood("1","101",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_the_world_islands),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_the_world_islands_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_the_world_islands_ar));
        CityWithNeighborhood cityWithNeighborhood102 = new CityWithNeighborhood("1","102",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_umm_al_sheif),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_umm_al_sheif_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_umm_al_sheif_ar));
        CityWithNeighborhood cityWithNeighborhood103 = new CityWithNeighborhood("1","103",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_umm_hurair),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_umm_hurair_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_umm_hurair_ar));
        CityWithNeighborhood cityWithNeighborhood104 = new CityWithNeighborhood("1","104",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_umm_ramool),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_umm_ramool_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_umm_ramool_ar));
        CityWithNeighborhood cityWithNeighborhood105 = new CityWithNeighborhood("1","105",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_umm_suqeim),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_umm_suqeim_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_umm_suqeim_ar));
        CityWithNeighborhood cityWithNeighborhood106 = new CityWithNeighborhood("1","106",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_victory_heights),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_victory_heights_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_victory_heights_ar));
        CityWithNeighborhood cityWithNeighborhood107 = new CityWithNeighborhood("1","107",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_wadi_al_amardi),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_wadi_al_amardi_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_wadi_al_amardi_ar));
        CityWithNeighborhood cityWithNeighborhood108 = new CityWithNeighborhood("1","108",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_world_trade_center),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_world_trade_center_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_world_trade_center_ar));
        CityWithNeighborhood cityWithNeighborhood109 = new CityWithNeighborhood("1","109",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_zabeel),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_zabeel_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_zabeel_ar));
        CityWithNeighborhood cityWithNeighborhood110 = new CityWithNeighborhood("1","110",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_zulal),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_zulal_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_zulal_ar));
        CityWithNeighborhood cityWithNeighborhood111 = new CityWithNeighborhood("1","111",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_badaa),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_badaa_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_badaa_ar));
        CityWithNeighborhood cityWithNeighborhood112 = new CityWithNeighborhood("1","112",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_nahda),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_nahda_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_nahda_ar));
        CityWithNeighborhood cityWithNeighborhood113 = new CityWithNeighborhood("1","113",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_rashidiya),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_rashidiya_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_rashidiya_ar));
        CityWithNeighborhood cityWithNeighborhood114 = new CityWithNeighborhood("1","114",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_south_dubai),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_south_dubai_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_south_dubai_ar));
        CityWithNeighborhood cityWithNeighborhood115 = new CityWithNeighborhood("1","115",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_damac_hills),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_damac_hills_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_damac_hills_ar));
        CityWithNeighborhood cityWithNeighborhood116 = new CityWithNeighborhood("1","116",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_bluewaters_island),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_bluewaters_island_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_bluewaters_island_ar));
        CityWithNeighborhood cityWithNeighborhood117 = new CityWithNeighborhood("1","117",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_mudon),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_mudon_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_mudon_ar));
        CityWithNeighborhood cityWithNeighborhood118 = new CityWithNeighborhood("1","118",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_liwan),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_liwan_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_liwan_ar));
        CityWithNeighborhood cityWithNeighborhood119 = new CityWithNeighborhood("1","119",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_serena),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_serena_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_serena_ar));
        CityWithNeighborhood cityWithNeighborhood120 = new CityWithNeighborhood("1","120",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_port_rashid),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_port_rashid_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_port_rashid_ar));
        CityWithNeighborhood cityWithNeighborhood121 = new CityWithNeighborhood("1","121",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_remram),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_remram_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_remram_ar));
        CityWithNeighborhood cityWithNeighborhood122 = new CityWithNeighborhood("1","122",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_sceince_park),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_sceince_park_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_sceince_park_ar));
        CityWithNeighborhood cityWithNeighborhood123 = new CityWithNeighborhood("1","123",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_residence_complex),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_residence_complex_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_residence_complex_ar));
        CityWithNeighborhood cityWithNeighborhood124 = new CityWithNeighborhood("1","124",context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_al_manara),context.getResources().getString(R.string.dubai_s),context.getResources().getString(R.string.dubai_al_manara_s),context.getResources().getString(R.string.dubai_ar),context.getResources().getString(R.string.dubai_al_manara_ar));


        CityWithNeighborhood cityWithNeighborhood125 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_gate_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_gate_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_gate_city_ar));
        CityWithNeighborhood cityWithNeighborhood126 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_airport),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_airport_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_airport_ar));
        CityWithNeighborhood cityWithNeighborhood127 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_badaa),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_badaa_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_badaa_ar));
        CityWithNeighborhood cityWithNeighborhood128 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_bahia),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_bahia_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_bahia_ar));
        CityWithNeighborhood cityWithNeighborhood129 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_baraha),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_baraha_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_baraha_ar));
        CityWithNeighborhood cityWithNeighborhood130 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_bateen),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_bateen_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_bateen_ar));
        CityWithNeighborhood cityWithNeighborhood131 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_dhafrah),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_dhafrah_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_dhafrah_ar));
        CityWithNeighborhood cityWithNeighborhood132 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_falah_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_falah_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_falah_city_ar));
        CityWithNeighborhood cityWithNeighborhood133 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_forsan),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_forsan_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_forsan_ar));
        CityWithNeighborhood cityWithNeighborhood134 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_ghadeer),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_ghadeer_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_ghadeer_ar));
        CityWithNeighborhood cityWithNeighborhood135 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_gurm),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_gurm_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_gurm_ar));
        CityWithNeighborhood cityWithNeighborhood136 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_gurm_west),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_gurm_west_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_gurm_west_ar));
        CityWithNeighborhood cityWithNeighborhood137 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_hudayriat_island),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_hudayriat_island_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_hudayriat_island_ar));
        CityWithNeighborhood cityWithNeighborhood138 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_ar));
        CityWithNeighborhood cityWithNeighborhood139 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_karama),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_karama_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_karama_ar));
        CityWithNeighborhood cityWithNeighborhood140 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_khalidiya),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_khalidiya_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_khalidiya_ar));
        CityWithNeighborhood cityWithNeighborhood141 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_khatim),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_khatim_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_khatim_ar));
        CityWithNeighborhood cityWithNeighborhood142 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_maffraq),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_maffraq_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_maffraq_ar));
        CityWithNeighborhood cityWithNeighborhood143 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_manaseer),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_manaseer_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_manaseer_ar));
        CityWithNeighborhood cityWithNeighborhood144 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_manhal),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_manhal_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_manhal_ar));
        CityWithNeighborhood cityWithNeighborhood145 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_maqtaa),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_maqtaa_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_maqtaa_ar));
        CityWithNeighborhood cityWithNeighborhood146 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_markaziyah),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_markaziyah_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_markaziyah_ar));
        CityWithNeighborhood cityWithNeighborhood147 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_maryah),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_maryah_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_maryah_ar));
        CityWithNeighborhood cityWithNeighborhood148 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_mina),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_mina_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_mina_ar));
        CityWithNeighborhood cityWithNeighborhood149 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_mushrif),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_mushrif_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_mushrif_ar));
        CityWithNeighborhood cityWithNeighborhood150 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_nahda),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_nahda_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_nahda_ar));
        CityWithNeighborhood cityWithNeighborhood151 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_nahyan_camp),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_nahyan_camp_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_nahyan_camp_ar));
        CityWithNeighborhood cityWithNeighborhood152 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_najda_street),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_najda_street_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_najda_street_ar));
        CityWithNeighborhood cityWithNeighborhood153 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_raha_beach),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_raha_beach_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_raha_beach_ar));
        CityWithNeighborhood cityWithNeighborhood154 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_raha_gardens),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_raha_gardens_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_raha_gardens_ar));
        CityWithNeighborhood cityWithNeighborhood155 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_raha_golf_gardens),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_raha_golf_gardens_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_raha_golf_gardens_ar));
        CityWithNeighborhood cityWithNeighborhood156 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_rahba),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_rahba_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_rahba_ar));
        CityWithNeighborhood cityWithNeighborhood157 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_rawdah),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_rawdah_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_rawdah_ar));
        CityWithNeighborhood cityWithNeighborhood158 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_rayhan),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_rayhan_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_rayhan_ar));
        CityWithNeighborhood cityWithNeighborhood159 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_reef),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_reef_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_reef_ar));
        CityWithNeighborhood cityWithNeighborhood160 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_reem_island),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_reem_island_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_reem_island_ar));
        CityWithNeighborhood cityWithNeighborhood161 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_ruwais),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_ruwais_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_ruwais_ar));
        CityWithNeighborhood cityWithNeighborhood162 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_salam_street),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_salam_street_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_salam_street_ar));
        CityWithNeighborhood cityWithNeighborhood163 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_samha),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_samha_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_samha_ar));
        CityWithNeighborhood cityWithNeighborhood164 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_shahama),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_shahama_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_shahama_ar));
        CityWithNeighborhood cityWithNeighborhood165 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_shamkha),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_shamkha_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_shamkha_ar));
        CityWithNeighborhood cityWithNeighborhood166 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_shawamekh),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_shawamekh_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_shawamekh_ar));
        CityWithNeighborhood cityWithNeighborhood167 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_silaa),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_silaa_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_silaa_ar));
        CityWithNeighborhood cityWithNeighborhood168 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_wahda),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_wahda_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_wahda_ar));
        CityWithNeighborhood cityWithNeighborhood169 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_wathba),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_wathba_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_wathba_ar));
        CityWithNeighborhood cityWithNeighborhood170 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_zaab),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_zaab_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_zaab_ar));
        CityWithNeighborhood cityWithNeighborhood171 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_zahraa),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_zahraa_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_zahraa_ar));
        CityWithNeighborhood cityWithNeighborhood172 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_baniyas),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_baniyas_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_baniyas_ar));
        CityWithNeighborhood cityWithNeighborhood173 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_between_tow_bridges),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_between_tow_bridges_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_between_tow_bridges_ar));
        CityWithNeighborhood cityWithNeighborhood174 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_building_materials_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_building_materials_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_building_materials_city_ar));
        CityWithNeighborhood cityWithNeighborhood175 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_capital_centre),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_capital_centre_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_capital_centre_ar));
        CityWithNeighborhood cityWithNeighborhood176 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_city_downtown),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_city_downtown_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_city_downtown_ar));
        CityWithNeighborhood cityWithNeighborhood177 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_corniche_area),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_corniche_area_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_corniche_area_ar));
        CityWithNeighborhood cityWithNeighborhood178 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_corniche_road),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_corniche_road_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_corniche_road_ar));
        CityWithNeighborhood cityWithNeighborhood179 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_ar));
        CityWithNeighborhood cityWithNeighborhood180 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_danet_abu_dhabi_ar));
        CityWithNeighborhood cityWithNeighborhood181 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_defence_street),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_defence_street_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_defence_street_ar));
        CityWithNeighborhood cityWithNeighborhood182 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_desert_village),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_desert_village_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_desert_village_ar));
        CityWithNeighborhood cityWithNeighborhood183 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_eastern_road),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_eastern_road_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_eastern_road_ar));
        CityWithNeighborhood cityWithNeighborhood184 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_electra_street),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_electra_street_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_electra_street_ar));
        CityWithNeighborhood cityWithNeighborhood185 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_ghantoot),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_ghantoot_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_ghantoot_ar));
        CityWithNeighborhood cityWithNeighborhood186 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_grand_mosque_district),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_grand_mosque_district_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_grand_mosque_district_ar));
        CityWithNeighborhood cityWithNeighborhood187 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_hamdan_street),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_hamdan_street_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_hamdan_street_ar));
        CityWithNeighborhood cityWithNeighborhood188 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_hameem),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_hameem_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_hameem_ar));
        CityWithNeighborhood cityWithNeighborhood189 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_hydra_village),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_hydra_village_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_hydra_village_ar));
        CityWithNeighborhood cityWithNeighborhood190 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_jawazat_street),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_jawazat_street_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_jawazat_street_ar));
        CityWithNeighborhood cityWithNeighborhood191 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_khalifa_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_khalifa_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_khalifa_city_ar));
        CityWithNeighborhood cityWithNeighborhood192 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_khalifa_street),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_khalifa_street_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_khalifa_street_ar));
        CityWithNeighborhood cityWithNeighborhood193 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_liwa),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_liwa_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_liwa_ar));
        CityWithNeighborhood cityWithNeighborhood194 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_lulu_island),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_lulu_island_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_lulu_island_ar));
        CityWithNeighborhood cityWithNeighborhood195 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_madinat_zayed),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_madinat_zayed_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_madinat_zayed_ar));
        CityWithNeighborhood cityWithNeighborhood196 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_marina_village),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_marina_village_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_marina_village_ar));
        CityWithNeighborhood cityWithNeighborhood197 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_masdar_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_masdar_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_masdar_city_ar));
        CityWithNeighborhood cityWithNeighborhood198 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_mina_zayed),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_mina_zayed_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_mina_zayed_ar));
        CityWithNeighborhood cityWithNeighborhood199 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_mohammad_bin_zayed_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_mohammad_bin_zayed_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_mohammad_bin_zayed_city_ar));
        CityWithNeighborhood cityWithNeighborhood200 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_muroor_area),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_muroor_area_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_muroor_area_ar));
        CityWithNeighborhood cityWithNeighborhood201 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_mussafah),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_mussafah_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_mussafah_ar));
        CityWithNeighborhood cityWithNeighborhood202 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_nurai_island),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_nurai_island_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_nurai_island_ar));
        CityWithNeighborhood cityWithNeighborhood203 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_saadiyat_island),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_saadiyat_island_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_saadiyat_island_ar));
        CityWithNeighborhood cityWithNeighborhood204 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_sas_al_nakheel),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_sas_al_nakheel_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_sas_al_nakheel_ar));
        CityWithNeighborhood cityWithNeighborhood205 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_tourist_club_area),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_tourist_club_area_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_tourist_club_area_ar));
        CityWithNeighborhood cityWithNeighborhood206 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_umm_al_nar),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_umm_al_nar_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_umm_al_nar_ar));
        CityWithNeighborhood cityWithNeighborhood207 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_yas_island),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_yas_island_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_yas_island_ar));
        CityWithNeighborhood cityWithNeighborhood208 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_zayed_military_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_zayed_military_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_zayed_military_city_ar));
        CityWithNeighborhood cityWithNeighborhood209 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_zayed_sports_city),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_zayed_sports_city_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_zayed_sports_city_ar));
        CityWithNeighborhood cityWithNeighborhood210 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_badaa),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_badaa_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_badaa_ar));
        CityWithNeighborhood cityWithNeighborhood211 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_ittihad_road_ar));
        CityWithNeighborhood cityWithNeighborhood212 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_city_downtown),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_city_downtown_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_city_downtown_ar));
        CityWithNeighborhood cityWithNeighborhood213 = new CityWithNeighborhood("2","1",context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_al_forsan),context.getResources().getString(R.string.abu_dhabi_s),context.getResources().getString(R.string.abu_dhabi_al_forsan_s),context.getResources().getString(R.string.abu_dhabi_ar),context.getResources().getString(R.string.abu_dhabi_al_forsan_ar));


        CityWithNeighborhood cityWithNeighborhood214 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_abu_shagra),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_abu_shagra_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_abu_shagra_ar));
        CityWithNeighborhood cityWithNeighborhood215 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_badie),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_badie_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_badie_ar));
        CityWithNeighborhood cityWithNeighborhood216 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_brashi),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_brashi_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_brashi_ar));
        CityWithNeighborhood cityWithNeighborhood217 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_butina),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_butina_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_butina_ar));
        CityWithNeighborhood cityWithNeighborhood218 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_ettihad_street),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_ettihad_street_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_ettihad_street_ar));
        CityWithNeighborhood cityWithNeighborhood219 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_fayha),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_fayha_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_fayha_ar));
        CityWithNeighborhood cityWithNeighborhood220 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_fisht),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_fisht_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_fisht_ar));
        CityWithNeighborhood cityWithNeighborhood221 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_garayen),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_garayen_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_garayen_ar));
        CityWithNeighborhood cityWithNeighborhood222 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_ghafeyah_area),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_ghafeyah_area_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_ghafeyah_area_ar));
        CityWithNeighborhood cityWithNeighborhood223 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_gharb),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_gharb_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_gharb_ar));
        CityWithNeighborhood cityWithNeighborhood224 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_ghuair),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_ghuair_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_ghuair_ar));
        CityWithNeighborhood cityWithNeighborhood225 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_jubail),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_jubail_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_jubail_ar));
        CityWithNeighborhood cityWithNeighborhood226 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_jurainah),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_jurainah_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_jurainah_ar));
        CityWithNeighborhood cityWithNeighborhood227 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_khezamia),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_khezamia_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_khezamia_ar));
        CityWithNeighborhood cityWithNeighborhood228 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_majaz),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_majaz_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_majaz_ar));
        CityWithNeighborhood cityWithNeighborhood229 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_mareija),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_mareija_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_mareija_ar));
        CityWithNeighborhood cityWithNeighborhood230 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_mujarrah),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_mujarrah_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_mujarrah_ar));
        CityWithNeighborhood cityWithNeighborhood231 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_nabba),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_nabba_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_nabba_ar));
        CityWithNeighborhood cityWithNeighborhood232 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_nahda),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_nahda_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_nahda_ar));
        CityWithNeighborhood cityWithNeighborhood233 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_naimiya_area),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_naimiya_area_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_naimiya_area_ar));
        CityWithNeighborhood cityWithNeighborhood234 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_nasreya),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_nasreya_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_nasreya_ar));
        CityWithNeighborhood cityWithNeighborhood235 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_nekhailat),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_nekhailat_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_nekhailat_ar));
        CityWithNeighborhood cityWithNeighborhood236 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_nouf),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_nouf_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_nouf_ar));
        CityWithNeighborhood cityWithNeighborhood237 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_nujoom_islands),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_nujoom_islands_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_nujoom_islands_ar));
        CityWithNeighborhood cityWithNeighborhood238 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_qarain),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_qarain_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_qarain_ar));
        CityWithNeighborhood cityWithNeighborhood239 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_qasbaa),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_qasbaa_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_qasbaa_ar));
        CityWithNeighborhood cityWithNeighborhood240 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_qasemiya),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_qasemiya_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_qasemiya_ar));
        CityWithNeighborhood cityWithNeighborhood241 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_rahmaniya),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_rahmaniya_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_rahmaniya_ar));
        CityWithNeighborhood cityWithNeighborhood242 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_ramla),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_ramla_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_ramla_ar));
        CityWithNeighborhood cityWithNeighborhood243 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_ramtha),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_ramtha_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_ramtha_ar));
        CityWithNeighborhood cityWithNeighborhood244 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_riffa_area),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_riffa_area_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_riffa_area_ar));
        CityWithNeighborhood cityWithNeighborhood245 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_riqqa),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_riqqa_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_riqqa_ar));
        CityWithNeighborhood cityWithNeighborhood246 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_sajaa),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_sajaa_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_sajaa_ar));
        CityWithNeighborhood cityWithNeighborhood247 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_shahba),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_shahba_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_shahba_ar));
        CityWithNeighborhood cityWithNeighborhood248 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_taawun),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_taawun_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_taawun_ar));
        CityWithNeighborhood cityWithNeighborhood249 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_sharq),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_sharq_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_sharq_ar));
        CityWithNeighborhood cityWithNeighborhood250 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_suyoh),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_suyoh_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_suyoh_ar));
        CityWithNeighborhood cityWithNeighborhood251 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_suyoh_suburb),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_suyoh_suburb_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_suyoh_suburb_ar));
        CityWithNeighborhood cityWithNeighborhood252 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_tai),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_tai_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_tai_ar));
        CityWithNeighborhood cityWithNeighborhood253 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_tayy_suburb),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_tayy_suburb_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_tayy_suburb_ar));
        CityWithNeighborhood cityWithNeighborhood254 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_wahda),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_wahda_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_wahda_ar));
        CityWithNeighborhood cityWithNeighborhood255 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_yarmouk),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_yarmouk_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_yarmouk_ar));
        CityWithNeighborhood cityWithNeighborhood256 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_zubair),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_zubair_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_zubair_ar));
        CityWithNeighborhood cityWithNeighborhood257 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_cornich_buhaira),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_cornich_buhaira_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_cornich_buhaira_ar));
        CityWithNeighborhood cityWithNeighborhood258 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_halwan),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_halwan_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_halwan_ar));
        CityWithNeighborhood cityWithNeighborhood259 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_hamriyah_free_zone),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_hamriyah_free_zone_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_hamriyah_free_zone_ar));
        CityWithNeighborhood cityWithNeighborhood260 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_jwezaa),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_jwezaa_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_jwezaa_ar));
        CityWithNeighborhood cityWithNeighborhood261 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_maysaloon),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_maysaloon_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_maysaloon_ar));
        CityWithNeighborhood cityWithNeighborhood262 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_muelih),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_muelih_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_muelih_ar));
        CityWithNeighborhood cityWithNeighborhood263 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_muelih_commercial),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_muelih_commercial_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_muelih_commercial_ar));
        CityWithNeighborhood cityWithNeighborhood264 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_mughaidir),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_mughaidir_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_mughaidir_ar));
        CityWithNeighborhood cityWithNeighborhood265 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_rolla_area),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_rolla_area_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_rolla_area_ar));
        CityWithNeighborhood cityWithNeighborhood266 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_sharjah_airport_freezon),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_sharjah_airport_freezon_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_sharjah_airport_freezon_ar));
        CityWithNeighborhood cityWithNeighborhood267 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_sharjah_industrial_area),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_sharjah_industrial_area_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_sharjah_industrial_area_ar));
        CityWithNeighborhood cityWithNeighborhood268 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_sharqan),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_sharqan_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_sharqan_ar));
        CityWithNeighborhood cityWithNeighborhood269 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_tilal_city),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_tilal_city_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_tilal_city_ar));
        CityWithNeighborhood cityWithNeighborhood270 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_um_altaraffa),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_um_altaraffa_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_um_altaraffa_ar));
        CityWithNeighborhood cityWithNeighborhood271 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_umm_khanoor),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_umm_khanoor_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_umm_khanoor_ar));
        CityWithNeighborhood cityWithNeighborhood272 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_wasit),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_wasit_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_wasit_ar));
        CityWithNeighborhood cityWithNeighborhood273 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_jada),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_jada_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_jada_ar));
        CityWithNeighborhood cityWithNeighborhood274 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_waterfront_city_marina),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_waterfront_city_marina_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_waterfront_city_marina_ar));
        CityWithNeighborhood cityWithNeighborhood275 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_hoshi),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_hoshi_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_hoshi_ar));
        CityWithNeighborhood cityWithNeighborhood276 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_university_city),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_university_city_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_university_city_ar));
        CityWithNeighborhood cityWithNeighborhood277 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_bu_tina),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_bu_tina_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_bu_tina_ar));
        CityWithNeighborhood cityWithNeighborhood278 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_azra),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_azra_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_azra_ar));
        CityWithNeighborhood cityWithNeighborhood279 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_ramaqiya),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_ramaqiya_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_ramaqiya_ar));
        CityWithNeighborhood cityWithNeighborhood280 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_falaj),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_falaj_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_falaj_ar));
        CityWithNeighborhood cityWithNeighborhood281 = new CityWithNeighborhood("3","1",context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_al_yash),context.getResources().getString(R.string.sharjah_s),context.getResources().getString(R.string.sharjah_al_yash_s),context.getResources().getString(R.string.sharjah_ar),context.getResources().getString(R.string.sharjah_al_yash_ar));


        CityWithNeighborhood cityWithNeighborhood282 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_ain_industrial_area),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_ain_industrial_area_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_ain_industrial_area_ar));
//        CityWithNeighborhood cityWithNeighborhood283 = new CityWithNeighborhood(context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_buraymi),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_buraymi_s));
        CityWithNeighborhood cityWithNeighborhood284 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_faqaa),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_faqaa_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_faqaa_ar));
        CityWithNeighborhood cityWithNeighborhood285 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_grayyeh),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_grayyeh_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_grayyeh_ar));
        CityWithNeighborhood cityWithNeighborhood286 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_hili),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_hili_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_hili_ar));
        CityWithNeighborhood cityWithNeighborhood287 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_jaheli),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_jaheli_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_jaheli_ar));
        CityWithNeighborhood cityWithNeighborhood288 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_jimi),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_jimi_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_jimi_ar));
        CityWithNeighborhood cityWithNeighborhood289 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_khabisi),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_khabisi_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_khabisi_ar));
        CityWithNeighborhood cityWithNeighborhood290 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_manaseer),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_manaseer_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_manaseer_ar));
        CityWithNeighborhood cityWithNeighborhood291 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_maqam),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_maqam_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_maqam_ar));
        CityWithNeighborhood cityWithNeighborhood292 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_markhaniya),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_markhaniya_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_markhaniya_ar));
        CityWithNeighborhood cityWithNeighborhood293 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_murabaa),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_murabaa_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_murabaa_ar));
        CityWithNeighborhood cityWithNeighborhood294 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_mutarad),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_mutarad_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_mutarad_ar));
        CityWithNeighborhood cityWithNeighborhood295 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_mutawaa),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_mutawaa_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_mutawaa_ar));
        CityWithNeighborhood cityWithNeighborhood296 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_muwahie),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_muwahie_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_muwahie_ar));
        CityWithNeighborhood cityWithNeighborhood297 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_muwaiji),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_muwaiji_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_muwaiji_ar));
        CityWithNeighborhood cityWithNeighborhood298 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_neyadat),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_neyadat_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_neyadat_ar));
        CityWithNeighborhood cityWithNeighborhood299 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_oyoun_village),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_oyoun_village_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_oyoun_village_ar));
        CityWithNeighborhood cityWithNeighborhood300 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_al_sinaiya),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_al_sinaiya_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_al_sinaiya_ar));
        CityWithNeighborhood cityWithNeighborhood301 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_tawam),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_tawam_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_tawam_ar));
        CityWithNeighborhood cityWithNeighborhood302 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_wahat_al_zaweya),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_wahat_al_zaweya_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_wahat_al_zaweya_ar));
        CityWithNeighborhood cityWithNeighborhood303 = new CityWithNeighborhood("4","1",context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_zakher),context.getResources().getString(R.string.al_ain_s),context.getResources().getString(R.string.al_ain_zakher_s),context.getResources().getString(R.string.al_ain_ar),context.getResources().getString(R.string.al_ain_zakher_ar));


        CityWithNeighborhood cityWithNeighborhood304 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_ain_ajman),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_ain_ajman_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_ain_ajman_ar));
        CityWithNeighborhood cityWithNeighborhood305 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_ajman_corniche_road),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_ajman_corniche_road_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_ajman_corniche_road_ar));
        CityWithNeighborhood cityWithNeighborhood306 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_ajman_downtown),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_ajman_downtown_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_ajman_downtown_ar));
        CityWithNeighborhood cityWithNeighborhood307 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_ajman_industrial_area),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_ajman_industrial_area_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_ajman_industrial_area_ar));
        CityWithNeighborhood cityWithNeighborhood308 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_ajman_meadows),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_ajman_meadows_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_ajman_meadows_ar));
        CityWithNeighborhood cityWithNeighborhood309 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_ajman_uptown),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_ajman_uptown_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_ajman_uptown_ar));
        CityWithNeighborhood cityWithNeighborhood310 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_amerah_village),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_amerah_village_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_amerah_village_ar));
        CityWithNeighborhood cityWithNeighborhood311 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_bustan),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_bustan_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_bustan_ar));
        CityWithNeighborhood cityWithNeighborhood312 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_hamidiya),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_hamidiya_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_hamidiya_ar));
        CityWithNeighborhood cityWithNeighborhood313 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_humaid_city),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_humaid_city_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_humaid_city_ar));
        CityWithNeighborhood cityWithNeighborhood314 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_ittihad_village),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_ittihad_village_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_ittihad_village_ar));
        CityWithNeighborhood cityWithNeighborhood315 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_mwaihat),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_mwaihat_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_mwaihat_ar));
        CityWithNeighborhood cityWithNeighborhood316 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_naemiyah),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_naemiyah_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_naemiyah_ar));
        CityWithNeighborhood cityWithNeighborhood317 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_raqaib),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_raqaib_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_raqaib_ar));
        CityWithNeighborhood cityWithNeighborhood318 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_rashidiya),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_rashidiya_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_rashidiya_ar));
        CityWithNeighborhood cityWithNeighborhood319 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_rawda),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_rawda_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_rawda_ar));
        CityWithNeighborhood cityWithNeighborhood320 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_rumaila),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_rumaila_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_rumaila_ar));
        CityWithNeighborhood cityWithNeighborhood321 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_sawan),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_sawan_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_sawan_ar));
        CityWithNeighborhood cityWithNeighborhood322 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_zahraa),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_zahraa_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_zahraa_ar));
        CityWithNeighborhood cityWithNeighborhood323 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_zorah),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_zorah_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_zorah_ar));
        CityWithNeighborhood cityWithNeighborhood324 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_awali_city),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_awali_city_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_awali_city_ar));
        CityWithNeighborhood cityWithNeighborhood325 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_garden_city),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_garden_city_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_garden_city_ar));
        CityWithNeighborhood cityWithNeighborhood326 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_green_city),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_green_city_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_green_city_ar));
        CityWithNeighborhood cityWithNeighborhood327 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_manama),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_manama_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_manama_ar));
        CityWithNeighborhood cityWithNeighborhood328 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_marmooka_city),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_marmooka_city_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_marmooka_city_ar));
        CityWithNeighborhood cityWithNeighborhood329 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_masfoot),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_masfoot_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_masfoot_ar));
        CityWithNeighborhood cityWithNeighborhood330 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_musheiref),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_musheiref_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_musheiref_ar));
        CityWithNeighborhood cityWithNeighborhood331 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_new_industrial_area),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_new_industrial_area_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_new_industrial_area_ar));
        CityWithNeighborhood cityWithNeighborhood332 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_park_view_city),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_park_view_city_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_park_view_city_ar));
        CityWithNeighborhood cityWithNeighborhood333 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_sheikh_khalifa_bin_zayed_street),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_sheikh_khalifa_bin_zayed_street_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_sheikh_khalifa_bin_zayed_street_ar));
        CityWithNeighborhood cityWithNeighborhood334 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_helio),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_helio_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_helio_ar));
        CityWithNeighborhood cityWithNeighborhood335 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_jurf),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_jurf_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_jurf_ar));
        CityWithNeighborhood cityWithNeighborhood336 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_sheikh_maktoum_bin_rashid_rd),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_sheikh_maktoum_bin_rashid_rd_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_sheikh_maktoum_bin_rashid_rd_ar));
        CityWithNeighborhood cityWithNeighborhood337 = new CityWithNeighborhood("5","1",context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_al_amerah),context.getResources().getString(R.string.ajman_s),context.getResources().getString(R.string.ajman_al_amerah_s),context.getResources().getString(R.string.ajman_ar),context.getResources().getString(R.string.ajman_al_amerah_ar));


        CityWithNeighborhood cityWithNeighborhood338 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_dhait),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_dhait_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_dhait_ar));
        CityWithNeighborhood cityWithNeighborhood339 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_ghubb),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_ghubb_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_ghubb_ar));
        CityWithNeighborhood cityWithNeighborhood340 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_huamra),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_ar));
        CityWithNeighborhood cityWithNeighborhood341 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_village),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_village_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_huamra_village_ar));
        CityWithNeighborhood cityWithNeighborhood342 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_juwais),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_juwais_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_juwais_ar));
        CityWithNeighborhood cityWithNeighborhood343 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_mamourah),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_mamourah_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_mamourah_ar));
        CityWithNeighborhood cityWithNeighborhood344 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_marjan_island),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_marjan_island_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_marjan_island_ar));
        CityWithNeighborhood cityWithNeighborhood345 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_nakheel),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_nakheel_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_nakheel_ar));
        CityWithNeighborhood cityWithNeighborhood346 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_qusaidat),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_qusaidat_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_qusaidat_ar));
        CityWithNeighborhood cityWithNeighborhood347 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_al_uraibi),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_al_uraibi_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_al_uraibi_ar));
        CityWithNeighborhood cityWithNeighborhood348 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_cornich_ras_al_khaima),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_cornich_ras_al_khaima_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_cornich_ras_al_khaima_ar));
        CityWithNeighborhood cityWithNeighborhood349 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_dana_island),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_dana_island_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_dana_island_ar));
        CityWithNeighborhood cityWithNeighborhood350 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_julfar),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_julfar_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_julfar_ar));
        CityWithNeighborhood cityWithNeighborhood351 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_khuzam),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_khuzam_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_khuzam_ar));
        CityWithNeighborhood cityWithNeighborhood352 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_mina_al_arab),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_mina_al_arab_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_mina_al_arab_ar));
        CityWithNeighborhood cityWithNeighborhood353 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_pak_ftz),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_pak_ftz_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_pak_ftz_ar));
        CityWithNeighborhood cityWithNeighborhood354 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_pak_industrial_and_technology_park),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_pak_industrial_and_technology_park_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_pak_industrial_and_technology_park_ar));
        CityWithNeighborhood cityWithNeighborhood355 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_creek),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_creek_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_creek_ar));
        CityWithNeighborhood cityWithNeighborhood356 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_gateway),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_gateway_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_gateway_ar));
        CityWithNeighborhood cityWithNeighborhood357 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_waterfront),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_waterfront_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_ras_al_khaimah_waterfront_ar));
        CityWithNeighborhood cityWithNeighborhood358 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_saraya_islands),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_saraya_islands_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_saraya_islands_ar));
        CityWithNeighborhood cityWithNeighborhood359 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_sheikh_mohammad_bin_zayed_road),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_sheikh_mohammad_bin_zayed_road_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_sheikh_mohammad_bin_zayed_road_ar));
        CityWithNeighborhood cityWithNeighborhood360 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_sidroh),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_sidroh_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_sidroh_ar));
        CityWithNeighborhood cityWithNeighborhood361 = new CityWithNeighborhood("6","1",context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_yasmin_village),context.getResources().getString(R.string.ras_al_khaimah_s),context.getResources().getString(R.string.ras_al_khaimah_yasmin_village_s),context.getResources().getString(R.string.ras_al_khaimah_ar),context.getResources().getString(R.string.ras_al_khaimah_yasmin_village_ar));


        CityWithNeighborhood cityWithNeighborhood362 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_aahad),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_aahad_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_aahad_ar));
        CityWithNeighborhood cityWithNeighborhood363 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_dar_al_baidaa),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_dar_al_baidaa_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_dar_al_baidaa_ar));
        CityWithNeighborhood cityWithNeighborhood364 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_haditha),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_haditha_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_haditha_ar));
        CityWithNeighborhood cityWithNeighborhood365 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_humra),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_humra_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_humra_ar));
        CityWithNeighborhood cityWithNeighborhood366 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_kaber),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_kaber_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_kaber_ar));
        CityWithNeighborhood cityWithNeighborhood367 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_khor),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_khor_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_khor_ar));
        CityWithNeighborhood cityWithNeighborhood368 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_maidan),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_maidan_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_maidan_ar));
        CityWithNeighborhood cityWithNeighborhood369 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_raas),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_raas_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_raas_ar));
        CityWithNeighborhood cityWithNeighborhood370 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_ramla),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_ramla_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_ramla_ar));
        CityWithNeighborhood cityWithNeighborhood371 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_raudah),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_raudah_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_raudah_ar));
        CityWithNeighborhood cityWithNeighborhood372 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_riqqa),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_riqqa_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_riqqa_ar));
        CityWithNeighborhood cityWithNeighborhood373 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_salam_city),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_salam_city_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_salam_city_ar));
        CityWithNeighborhood cityWithNeighborhood374 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_salamah),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_salamah_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_salamah_ar));
        CityWithNeighborhood cityWithNeighborhood375 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_al_surra),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_al_surra_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_al_surra_ar));
        CityWithNeighborhood cityWithNeighborhood376 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_emirates_modern_industrial),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_emirates_modern_industrial_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_emirates_modern_industrial_ar));
        CityWithNeighborhood cityWithNeighborhood377 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_falaj_al_moalla),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_falaj_al_moalla_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_falaj_al_moalla_ar));
        CityWithNeighborhood cityWithNeighborhood378 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_khor_al_beidah),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_khor_al_beidah_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_khor_al_beidah_ar));
        CityWithNeighborhood cityWithNeighborhood379 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_old_induustrial_area),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_old_induustrial_area_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_old_induustrial_area_ar));
        CityWithNeighborhood cityWithNeighborhood380 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_umm_al_quwain_marina),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_umm_al_quwain_marina_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_umm_al_quwain_marina_ar));
        CityWithNeighborhood cityWithNeighborhood381 = new CityWithNeighborhood("7","1",context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_white_bay),context.getResources().getString(R.string.um_al_quwain_s),context.getResources().getString(R.string.um_al_quwain_white_bay_s),context.getResources().getString(R.string.um_al_quwain_ar),context.getResources().getString(R.string.um_al_quwain_white_bay_ar));


        CityWithNeighborhood cityWithNeighborhood382 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_sharm),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_sharm_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_sharm_ar));
        CityWithNeighborhood cityWithNeighborhood383 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_gurfah),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_gurfah_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_gurfah_ar));
        CityWithNeighborhood cityWithNeighborhood384 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_faseel),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_gurfah_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_gurfah_ar));
        CityWithNeighborhood cityWithNeighborhood385 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_fujairah_freezone),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_fujairah_freezone_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_fujairah_freezone_ar));
        CityWithNeighborhood cityWithNeighborhood386 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_sakamkam),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_sakamkam_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_sakamkam_ar));
        CityWithNeighborhood cityWithNeighborhood387 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_saniaya),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_saniaya_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_saniaya_ar));
        CityWithNeighborhood cityWithNeighborhood388 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_merashid),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_merashid_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_merashid_ar));
        CityWithNeighborhood cityWithNeighborhood389 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_corniche_fujairah),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_corniche_fujairah_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_corniche_fujairah_ar));
        CityWithNeighborhood cityWithNeighborhood390 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_deba_fujairah),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_deba_fujairah_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_deba_fujairah_ar));
        CityWithNeighborhood cityWithNeighborhood391 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_downtown_fujairah),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_deba_fujairah_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_deba_fujairah_ar));
        CityWithNeighborhood cityWithNeighborhood392 = new CityWithNeighborhood("8","1",context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_sheikh_hamad_bin_abdullah_st),context.getResources().getString(R.string.fujairah_s),context.getResources().getString(R.string.fujairah_sheikh_hamad_bin_abdullah_st_s),context.getResources().getString(R.string.fujairah_ar),context.getResources().getString(R.string.fujairah_sheikh_hamad_bin_abdullah_st_ar));


        CityWithNeighborhood cityWithNeighborhood393 = new CityWithNeighborhood("100","100",context.getResources().getString(R.string.can_not_find_city),context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find_city),context.getResources().getString(R.string.can_not_find),context.getResources().getString(R.string.can_not_find_city),context.getResources().getString(R.string.can_not_find));


        cityWithNeighborhoodArrayL.add(cityWithNeighborhood1);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood2);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood3);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood4);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood5);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood6);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood7);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood8);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood9);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood10);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood11);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood12);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood13);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood14);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood15);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood16);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood17);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood18);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood19);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood20);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood21);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood22);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood23);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood24);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood25);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood26);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood27);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood28);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood29);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood30);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood31);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood32);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood33);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood34);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood35);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood36);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood37);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood38);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood39);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood40);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood41);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood42);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood43);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood44);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood45);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood46);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood47);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood48);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood49);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood50);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood51);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood52);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood53);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood54);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood55);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood56);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood57);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood58);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood59);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood60);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood61);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood62);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood63);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood64);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood65);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood66);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood67);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood68);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood69);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood70);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood71);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood72);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood73);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood74);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood75);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood76);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood77);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood78);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood79);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood80);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood81);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood82);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood83);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood84);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood85);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood86);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood87);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood88);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood89);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood90);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood91);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood92);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood93);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood94);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood95);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood96);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood97);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood98);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood99);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood100);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood101);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood102);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood103);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood104);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood105);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood106);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood107);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood108);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood109);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood110);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood111);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood112);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood113);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood114);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood115);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood116);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood117);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood118);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood119);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood120);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood121);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood122);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood123);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood124);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood125);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood126);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood127);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood128);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood129);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood130);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood131);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood132);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood133);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood134);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood135);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood136);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood137);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood138);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood139);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood140);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood141);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood142);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood143);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood144);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood145);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood146);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood147);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood148);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood149);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood150);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood151);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood152);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood153);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood154);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood155);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood156);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood157);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood158);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood159);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood160);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood161);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood162);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood163);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood164);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood165);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood166);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood167);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood168);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood169);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood170);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood171);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood172);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood173);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood174);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood175);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood176);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood177);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood178);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood179);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood180);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood181);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood182);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood183);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood184);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood185);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood186);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood187);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood188);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood189);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood190);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood191);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood192);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood193);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood194);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood195);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood196);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood197);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood198);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood199);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood200);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood201);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood202);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood203);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood204);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood205);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood206);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood207);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood208);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood209);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood210);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood211);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood212);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood213);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood214);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood215);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood216);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood217);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood218);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood219);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood220);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood221);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood222);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood223);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood224);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood225);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood226);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood227);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood228);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood229);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood230);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood231);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood232);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood233);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood234);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood235);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood236);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood237);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood238);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood239);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood240);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood241);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood242);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood243);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood244);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood245);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood246);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood247);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood248);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood249);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood250);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood251);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood252);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood253);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood254);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood255);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood256);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood257);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood258);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood259);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood260);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood261);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood262);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood263);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood264);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood265);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood266);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood267);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood268);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood269);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood270);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood271);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood272);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood273);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood274);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood275);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood276);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood277);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood278);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood279);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood280);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood281);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood282);
//        cityWithNeighborhoodArrayL.add(cityWithNeighborhood283);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood284);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood285);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood286);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood287);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood288);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood289);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood290);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood291);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood292);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood293);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood294);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood295);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood296);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood297);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood298);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood299);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood300);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood301);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood302);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood303);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood304);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood305);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood306);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood307);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood308);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood309);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood310);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood311);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood312);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood313);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood314);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood315);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood316);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood317);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood318);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood319);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood320);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood321);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood322);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood323);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood324);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood325);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood326);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood327);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood328);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood329);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood330);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood331);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood332);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood333);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood334);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood335);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood336);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood337);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood338);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood339);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood340);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood341);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood342);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood343);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood344);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood345);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood346);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood347);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood348);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood349);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood350);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood351);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood352);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood353);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood354);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood355);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood356);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood357);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood358);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood359);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood360);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood361);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood362);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood363);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood364);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood365);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood366);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood367);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood368);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood369);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood370);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood371);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood372);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood373);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood374);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood375);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood376);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood377);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood378);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood379);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood380);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood381);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood382);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood383);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood384);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood385);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood386);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood387);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood388);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood389);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood390);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood391);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood392);
        cityWithNeighborhoodArrayL.add(cityWithNeighborhood393);


        return cityWithNeighborhoodArrayL;
    }

    public static ArrayList<Neighborhood> resortNeighborhoodArrayL
            (ArrayList<Neighborhood> neighborhoodArrayL, Context context){

        String neighborhood = getUserNeighborhoodFromSP(context);
        Neighborhood neighborhood1 = null;
        for (int i =0;i<neighborhoodArrayL.size();i++)
        {
            if (neighborhoodArrayL.get(i).getNeighborhood().equals(neighborhood))
            {
                neighborhood1 = neighborhoodArrayL.get(i);
                neighborhoodArrayL.remove(i);
            }
        }
        if (neighborhood1!=null)
        {
            neighborhoodArrayL.add(0,neighborhood1);
        }

        return neighborhoodArrayL;
    }

}
