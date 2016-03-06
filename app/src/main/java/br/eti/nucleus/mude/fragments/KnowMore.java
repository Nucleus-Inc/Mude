package br.eti.nucleus.mude.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.eti.nucleus.mude.R;
import br.eti.nucleus.mude.activitys.MainActivity;

public class KnowMore extends Fragment implements View.OnClickListener{

    private LinearLayout handcuffs;
    private LinearLayout refund;
    private LinearLayout strike;
    private LinearLayout positive_dynamic;
    private LinearLayout prisioner;
    private LinearLayout exercise;
    private LinearLayout law;
    private LinearLayout rules;
    private LinearLayout money_bag;
    private LinearLayout expensive;

    private void listen_clickeds(){
        handcuffs = (LinearLayout) getActivity().findViewById(R.id.know_more_handcuffs);
        if(handcuffs!=null){
            handcuffs.setOnClickListener(this);
            refund = (LinearLayout) getActivity().findViewById(R.id.know_more_refund);
            if(refund!=null){
                refund.setOnClickListener(this);
                strike = (LinearLayout) getActivity().findViewById(R.id.know_more_strike);
                if(strike!=null){
                    strike.setOnClickListener(this);
                    positive_dynamic = (LinearLayout) getActivity().findViewById(R.id.know_more_positive_dynamic);
                    if(positive_dynamic!=null){
                        positive_dynamic.setOnClickListener(this);
                        prisioner = (LinearLayout) getActivity().findViewById(R.id.know_more_priosioner);
                        if(prisioner!=null){
                            prisioner.setOnClickListener(this);
                            exercise = (LinearLayout) getActivity().findViewById(R.id.know_more_exercise);
                            if(exercise!=null){
                                exercise.setOnClickListener(this);
                                law = (LinearLayout) getActivity().findViewById(R.id.know_more_law);
                                if(law!=null){
                                    law.setOnClickListener(this);
                                    rules = (LinearLayout) getActivity().findViewById(R.id.know_more_rules);
                                    if(rules!=null){
                                        rules.setOnClickListener(this);
                                        money_bag = (LinearLayout) getActivity().findViewById(R.id.know_more_money_bag);
                                        if(money_bag!=null){
                                            money_bag.setOnClickListener(this);
                                            expensive = (LinearLayout) getActivity().findViewById(R.id.know_more_expensive_2);
                                            if(expensive!=null){
                                                expensive.setOnClickListener(this);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void set_title(){
        MainActivity.myToolbar.setTitle("Saiba Mais");
    }

    private void set_menu_button(){
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = false;
        return inflater.inflate(R.layout.fragment_ten_measures_know_more,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_know_more, menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        set_title();
        listen_clickeds();
        set_menu_button();
    }

    @Override
    public void onClick(View v) {
        Fragment f = null;

        switch (v.getId()){
            case R.id.know_more_handcuffs:
                f = new Handcuffs();
                break;
            case R.id.know_more_refund:
                f = new Refund();
                break;
            case R.id.know_more_strike:
                f = new Strikes();
                break;
            case R.id.know_more_positive_dynamic:
                f = new PositiveDynamic();
                break;
            case R.id.know_more_priosioner:
                f = new Prisioner();
                break;
            case R.id.know_more_exercise:
                f = new Exercise();
                break;
            case R.id.know_more_law:
                f = new Law();
                break;
            case R.id.know_more_rules:
                f = new Rules();
                break;
            case R.id.know_more_money_bag:
                f = new MoneyBag();
                break;
            case R.id.know_more_expensive_2:
                f = new Expensive();
                break;
        }

        if(f!=null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).addToBackStack(null).commit();
    }
}
