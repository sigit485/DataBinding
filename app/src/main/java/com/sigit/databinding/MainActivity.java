package com.sigit.databinding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.sigit.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.setNavigator(this);
        viewModel.setUser();
        viewModel.getUser().observe(this, user -> {
            binding.recyclerView.setAdapter(new MainAdapter(user, viewModel));
        });

    }

    @Override
    public void onItemClick(User user) {
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//            alert.setMessage(user.name + "\n" + user.email);
//               if (user.isMark.get()){
//                    alert.setPositiveButton("UNMARK", (dialog, which) -> {
//                       user.isMark.set(false);
//                       dialog.dismiss();
//                   });
//               } else {
//                   alert.setPositiveButton("MARK", (dialog, which) -> {
//                       user.isMark.set(true);
//                       dialog.dismiss();
//                   });
//               }
//                alert.show();

        // Create Alert using Builder
        CFAlertDialog.Builder alert = new CFAlertDialog.Builder(this);
        alert.setMessage(user.name + "\n" + user.email);
        if (user.isMark.get()) {
            alert.addButton("UNMARK", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                Toast.makeText(MainActivity.this, "Unmark Item Selected", Toast.LENGTH_SHORT).show();
                user.isMark.set(false);
                dialog.dismiss();
            });
        } else {
            alert.addButton("MARK", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                Toast.makeText(MainActivity.this, "Mark Item Selected", Toast.LENGTH_SHORT).show();
                user.isMark.set(true);
                dialog.dismiss();
            });
        }
        alert.show();
    }
}