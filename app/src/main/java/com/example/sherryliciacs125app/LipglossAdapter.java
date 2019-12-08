//package com.example.sherryliciacs125app;
//
//public class LipglossAdapter {
//    public class LipglossAdapter extends RecyclerView.Adapter<LipglossAdapter.ViewHolder> {
//
//        private  List<Lipgloss> mFruitList;
//        static class ViewHolder extends RecyclerView.ViewHolder{
//            ImageView lipglossImage
//            TextView lipglossName;
//
//            public ViewHolder (View view)
//            {
//                super(view);
//                lipglossImage = (ImageView) view.findViewById(R.id.lipgloss_image);
//                lipglossName = (TextView) view.findViewById(R.id.lipglossName);
//            }
//
//        }
//
//        public  FruitAdapter (List <Lipgloss> fruitList){
//            mFruitList = fruitList;
//        }
//
//        @Override
//
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
//            ViewHolder holder = new ViewHolder(view);
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position){
//
//            Fruit fruit = mFruitList.get(position);
//            holder.fruitImage.setImageResource(fruit.getImageId());
//            holder.fruitName.setText(fruit.getName());
//        }
//
//        @Override
//        public int getItemCount(){
//            return mFruitList.size();
//        }
//    }