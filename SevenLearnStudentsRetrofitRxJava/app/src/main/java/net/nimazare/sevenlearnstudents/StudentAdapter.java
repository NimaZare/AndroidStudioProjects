package net.nimazare.sevenlearnstudents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bind(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void addStudent(Student student){
        this.students.add(0, student);
        notifyItemInserted(0);
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvFirstCharacter, tvFullName, tvCourse, tvScore;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstCharacter = itemView.findViewById(R.id.tv_student_firstCharacter);
            tvFullName = itemView.findViewById(R.id.tv_student_fullName);
            tvCourse = itemView.findViewById(R.id.tv_student_course);
            tvScore = itemView.findViewById(R.id.tv_student_score);
        }

        public void bind(Student student) {
            tvFirstCharacter.setText(student.getFirstName().substring(0, 1));
            tvFullName.setText(student.getFirstName() + " " + student.getLastName());
            tvCourse.setText(student.getCourse());
            tvScore.setText(String.valueOf(student.getScore()));
        }
    }
}
