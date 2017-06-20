package nofhaderech.nof.com.nofhaderech;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class GetRidePage {

    private android.content.Context Context;
    private EditText DateEditText;
    private EditText TimeFromText;
    private EditText TimeToText;

    private int Year;
    private int Month;
    private int Day;

    private int FromHour;
    private int FromMinutes;
    private int ToHour;
    private int ToMinutes;

    GetRidePage(final View contentDriver) {
        Context = contentDriver.getContext();
        DateEditText = contentDriver.findViewById(R.id.getRideDay);

        TimeFromText = contentDriver.findViewById(R.id.getRideFromTime);
        TimeToText = contentDriver.findViewById(R.id.getRideToTime);

        InitializeDate();
        InitializeFromTime();
        InitializeToTime();
    }

    private void InitializeDate() {
        Calendar calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        DateEditText.setText("" + Day + " - " + Month + " - " + Year);

        DateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(Context, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        selectedmonth = selectedmonth + 1;
                        Year = selectedyear;
                        Month = selectedmonth;
                        Day = selectedday;
                        DateEditText.setText("" + Day + " - " + Month + " - " + Year);
                    }
                }, Year, Month, Day);
                mDatePicker.setTitle("בחר יום");
                mDatePicker.show();
            }
        });
    }

    private void InitializeFromTime() {
        Calendar calendar = Calendar.getInstance();
        FromHour = calendar.get(Calendar.HOUR_OF_DAY) + 1;
        FromMinutes = 0;

        TimeFromText.setText("" + String.format("%02d", FromHour) + ":" + String.format("%02d", FromMinutes));

        TimeFromText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinutes) {
                        FromHour = selectedHour;
                        FromMinutes = selectedMinutes;
                        TimeFromText.setText("" + String.format("%02d", FromHour) + ":" + String.format("%02d", FromMinutes));
                    }
                }, FromHour, FromMinutes, true);
                mTimePicker.setTitle("בחר שעת התחלה");
                mTimePicker.show();
            }
        });
    }

    private void InitializeToTime() {
        Calendar calendar = Calendar.getInstance();
        ToHour = calendar.get(Calendar.HOUR_OF_DAY) + 2;
        ToMinutes = 0;

        TimeToText.setText("" + String.format("%02d", ToHour) + ":" + String.format("%02d", ToMinutes));

        TimeToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinutes) {
                        ToHour = selectedHour;
                        ToMinutes = selectedMinutes;
                        TimeToText.setText("" + String.format("%02d", ToHour) + ":" + String.format("%02d", ToMinutes));
                    }
                }, ToHour, ToMinutes, true);
                mTimePicker.setTitle("בחר שעת סיום");
                mTimePicker.show();
            }
        });
    }

}
