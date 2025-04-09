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
import { motion } from 'framer-motion';
import { FiFlag, FiEye, FiHeart, FiShoppingCart, FiRepeat, FiShare2, FiCheckCircle } from 'react-icons/fi';

interface JourneyStep {
  title: string;
  icon?: React.ReactNode;
  description?: string;
}

const HorizontalJourneyRoadmap: React.FC<{ steps: JourneyStep[] }> = ({ steps }) => {
  const pathVariants = {
    hidden: { pathLength: 0 },
    visible: { 
      pathLength: 1,
      transition: { duration: 1.5, ease: "easeInOut" }
    }
  };

  const nodeVariants = {
    hidden: { scale: 0 },
    visible: { 
      scale: 1,
      transition: { type: "spring", damping: 10, stiffness: 100 }
    }
  };

  return (
    <div className="max-w-6xl mx-auto px-4 py-12">
      <h1 className="text-3xl font-bold text-center mb-16 text-indigo-700">Customer Journey Road</h1>
      
      <div className="relative h-48">
        {/* SVG Pathway */}
        <svg className="absolute w-full h-full" viewBox="0 0 1000 200" preserveAspectRatio="none">
          <motion.path
            d={generateCurvedPath(steps.length, 1000, 100)}
            fill="none"
            stroke="#818CF8"
            strokeWidth="4"
            strokeLinecap="round"
            strokeDasharray="0 0"
            initial="hidden"
            animate="visible"
            variants={pathVariants}
          />
        </svg>

        {/* Steps */}
        <div className="relative flex justify-between h-full">
          {steps.map((step, index) => (
            <motion.div
              key={index}
              className="absolute flex flex-col items-center"
              style={{
                left: `${(index / (steps.length - 1)) * 100}%`,
                top: index % 2 === 0 ? '30%' : '70%',
                transform: 'translateX(-50%)'
              }}
              initial="hidden"
              animate="visible"
              variants={nodeVariants}
              transition={{ delay: index * 0.2 }}
            >
              {/* Animated Node */}
              <motion.div 
                className={`w-16 h-16 rounded-full flex items-center justify-center text-white font-bold text-xl mb-2 
                  ${getStepColor(index)} shadow-xl border-4 border-white`}
                whileHover={{ scale: 1.1 }}
                whileTap={{ scale: 0.9 }}
              >
                {step.icon || index + 1}
              </motion.div>
              
              {/* Label */}
              <motion.div 
                className="text-center"
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                transition={{ delay: index * 0.2 + 0.3 }}
              >
                <h3 className="text-lg font-semibold text-gray-800">{step.title}</h3>
                {step.description && (
                  <p className="text-sm text-gray-600 mt-1">{step.description}</p>
                )}
              </motion.div>
            </motion.div>
          ))}
        </div>
      </div>
    </div>
  );
};

// Generate a curved SVG path
const generateCurvedPath = (count: number, width: number, height: number): string => {
  const segmentWidth = width / (count - 1);
  let path = `M0,${height/2}`;
  
  for (let i = 1; i < count; i++) {
    const x = i * segmentWidth;
    const y = i % 2 === 0 ? height * 0.3 : height * 0.7;
    path += ` Q${x - segmentWidth/2},${height/2} ${x},${y}`;
  }
  
  return path;
};

// Color mapping for nodes
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

// Example usage with icons
export const CustomerJourneyExample = () => {
  const steps: JourneyStep[] = [
    { title: 'START', icon: <FiFlag size={24} /> },
    { title: 'AWARENESS', icon: <FiEye size={24} /> },
    { title: 'INTEREST', icon: <FiHeart size={24} /> },
    { title: 'PURCHASE', icon: <FiShoppingCart size={24} /> },
    { title: 'RETENTION', icon: <FiRepeat size={24} /> },
    { title: 'ADVOCACY', icon: <FiShare2 size={24} /> },
    { title: 'FINISH', icon: <FiCheckCircle size={24} /> }
  ];

  return (
    <div className="min-h-screen bg-gray-50 py-12">
      <HorizontalJourneyRoadmap steps={steps} />
    </div>
  );
};

*/

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




