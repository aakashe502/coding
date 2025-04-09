package Custom_Sorting;
import java.io.*;
import java.util.*;

public class carpooling {
    public static void main(String args[])throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int n=Integer.parseInt(br.readLine());
       int arr[][]=new int[n][2];
       int i;
       for(i=0;i<n;i++){
        String a[]=br.readLine().split(" ");
        int x=Integer.parseInt(a[0]);
        int y=Integer.parseInt(a[1]);
        arr[i]=new int[]{x,y};
       }
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                if(a[1]==b[1])
                return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        for(i=0;i<n;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
       
    }
    
}

import React from "react";
import journeyData from "../data/journeyData";

const UserJourney = () => {
  const stepGap = 140; // horizontal spacing between each step

  return (
    <div className="relative w-full overflow-x-auto py-10">
      {/* SVG paths layer */}
      <svg
        className="absolute top-0 left-0 w-full h-full z-0"
        viewBox={`0 0 ${journeyData.length * stepGap} 200`}
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        {journeyData.slice(0, -1).map((step, index) => {
          const x1 = index * stepGap + 24;
          const x2 = (index + 1) * stepGap;
          const y1 = index % 2 === 0 ? 40 : 120;
          const y2 = index % 2 === 0 ? 120 : 40;
          const mx = (x1 + x2) / 2;

          return (
            <path
              key={index}
              d={`M ${x1},${y1} Q ${mx},${(y1 + y2) / 2} ${x2},${y2}`}
              stroke="#a3a3a3"
              strokeWidth="2"
              strokeDasharray="6 6"
              fill="none"
            />
          );
        })}
      </svg>

      {/* Journey steps */}
      <div className="relative flex items-start gap-[80px] px-10 z-10">
        {journeyData.map((item, index) => (
          <div
            key={item.id}
            className={`flex flex-col items-center relative ${
              index % 2 === 0 ? "mt-0" : "mt-20"
            }`}
          >
            {/* Circle Step */}
            <div className="w-12 h-12 rounded-full bg-orange-500 text-white flex items-center justify-center font-bold shadow-md">
              {item.id}
            </div>

            {/* Title */}
            <span className="mt-2 text-sm text-center w-24">{item.title}</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserJourney;

