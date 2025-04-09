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

/*

import React from 'react';

interface JourneyStep {
  title: string;
  description?: string; // Optional for this layout
}

interface UserJourneyRoadmapProps {
  steps: JourneyStep[];
}

const HorizontalJourneyRoadmap: React.FC<UserJourneyRoadmapProps> = ({ steps }) => {
  return (
    <div className="max-w-6xl mx-auto px-4 py-8">
      <h1 className="text-3xl font-bold text-center mb-12 text-indigo-700">Customer Journey Road</h1>
      
      <div className="relative">
        {/* Main horizontal pathway line */}
        <div className="absolute left-0 right-0 top-1/2 h-2 bg-indigo-300 transform -translate-y-1/2"></div>
        
        <div className="flex justify-between relative z-10">
          {steps.map((step, index) => (
            <div key={index} className="flex flex-col items-center">
              {/* Step node */}
              <div className={`w-16 h-16 rounded-full flex items-center justify-center text-white font-bold text-lg mb-2 
                ${getStepColor(index)} shadow-lg border-4 border-white`}>
                {index + 1}
              </div>
              
              {/* Step label */}
              <div className="text-center mt-2">
                <h3 className="text-lg font-semibold text-gray-800">{step.title}</h3>
                {step.description && (
                  <p className="text-sm text-gray-600 mt-1">{step.description}</p>
                )}
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

// Helper function to get different background colors for nodes
const getStepColor = (index: number): string => {
  const colors = [
    'bg-blue-500',    // START
    'bg-indigo-500',  // AWARENESS
    'bg-purple-500',  // INTEREST
    'bg-pink-500',    // PURCHASE
    'bg-green-500',   // RETENTION
    'bg-teal-500',    // ADVOCACY
    'bg-yellow-500',  // FINISH
  ];
  return colors[index % colors.length];
};

export default HorizontalJourneyRoadmap;




import React from 'react';
import UserJourneyRoadmap from './UserJourneyRoadmap';

const App = () => {
  const userJourney = [
    {
      title: 'Awareness',
      description: 'User first discovers your product or service',
      actions: [
        'See social media ad',
        'Read blog post',
        'Word of mouth referral'
      ]
    },
    {
      title: 'Consideration',
      description: 'User evaluates whether your product fits their needs',
      actions: [
        'Visit pricing page',
        'Compare features',
        'Read customer reviews'
      ]
    },
    {
      title: 'Purchase',
      description: 'User makes the decision to buy or subscribe',
      actions: [
        'Add to cart',
        'Complete checkout',
        'Receive confirmation'
      ]
    },
    {
      title: 'Retention',
      description: 'User continues to use and find value in your product',
      actions: [
        'Receive onboarding emails',
        'Use key features',
        'Renew subscription'
      ]
    },
    {
      title: 'Advocacy',
      description: 'User becomes a promoter of your product',
      actions: [
        'Refer friends',
        'Write positive review',
        'Share on social media'
      ]
    }
  ];

  return (
    <div className="min-h-screen bg-gray-50 py-12">
      <UserJourneyRoadmap journey={userJourney} />
    </div>
  );
};

export default App;




